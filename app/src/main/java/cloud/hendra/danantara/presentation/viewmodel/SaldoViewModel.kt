package cloud.hendra.danantara.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cloud.hendra.danantara.domain.model.SaldoResponse
import cloud.hendra.danantara.domain.usecase.saldo.CheckOpenUseCase
import cloud.hendra.danantara.domain.usecase.saldo.OpenStoreUseCase
import cloud.hendra.danantara.utils.state.ResultState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SaldoViewModel(
    private val checkOpenUseCase: CheckOpenUseCase,
    private val openStoreUseCase: OpenStoreUseCase,
) : ViewModel() {
    private val _saldo = MutableStateFlow<ResultState<SaldoResponse>>(ResultState.Initial)
    val saldo: StateFlow<ResultState<SaldoResponse>> = _saldo

    private val _open = MutableStateFlow<ResultState<SaldoResponse>>(ResultState.Initial)
    val open: StateFlow<ResultState<SaldoResponse>> = _open

    fun checkSaldo() {
        _saldo.value = ResultState.Loading
        viewModelScope.launch {
            try {
                val result = checkOpenUseCase()
                _saldo.value = result
            } catch (e: Exception) {
                _saldo.value = ResultState.Error(e.message)
            }
        }
    }

    fun openStore(shift: String, awal: Int) {
        _open.value = ResultState.Loading
        viewModelScope.launch {
            try {
                val result = openStoreUseCase(shift, awal)
                _open.value = result
            } catch (e: Exception) {
                _open.value = ResultState.Error(e.message)
            }
        }
    }
}