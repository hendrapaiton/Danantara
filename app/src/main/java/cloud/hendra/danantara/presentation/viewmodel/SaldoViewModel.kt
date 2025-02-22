package cloud.hendra.danantara.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cloud.hendra.danantara.domain.model.SaldoResponse
import cloud.hendra.danantara.domain.usecase.saldo.CheckOpenUseCase
import cloud.hendra.danantara.utils.state.ResultState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SaldoViewModel(private val checkOpenUseCase: CheckOpenUseCase) : ViewModel() {
    private val _saldo = MutableStateFlow<ResultState<SaldoResponse>>(ResultState.Loading)
    val saldo: StateFlow<ResultState<SaldoResponse>> = _saldo

    fun checkSaldo() {
        _saldo.value = ResultState.Loading
        viewModelScope.launch {
            try {
                val result = checkOpenUseCase()
                _saldo.value = result
            } catch (e: Exception) {
                Log.d("SaldoViewModel", "checkSaldo: ${e.message}")
                _saldo.value = ResultState.Error(e.message)
            }
        }
    }
}