package cloud.hendra.danantara.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cloud.hendra.danantara.domain.usecase.LoginUseCase
import cloud.hendra.danantara.domain.usecase.RefreshUseCase
import cloud.hendra.danantara.utils.authentication.AuthState.*
import cloud.hendra.danantara.utils.state.GuardState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel(
    private val loginUseCase: LoginUseCase,
    private val refreshUseCase: RefreshUseCase
) : ViewModel() {
    private val _authState = MutableStateFlow<GuardState>(GuardState.Unauthenticated)
    val authState: StateFlow<GuardState> = _authState

    private val _refreshState = MutableStateFlow<GuardState>(GuardState.Unauthenticated)
    val refreshState: StateFlow<GuardState> = _refreshState

    fun login(username: String, password: String) {
        viewModelScope.launch {
            _authState.value = GuardState.Unauthenticated
            when (val result = loginUseCase(username, password)) {
                is Success -> _authState.value = GuardState.Authenticated
                is Error -> _authState.value = GuardState.Error(result.message)
                Loading -> _authState.value = GuardState.Loading
                Idle -> _authState.value = GuardState.Unauthenticated
            }
        }
    }

    fun refresh() {
        viewModelScope.launch {
            _refreshState.value = GuardState.Unauthenticated
            when (val result = refreshUseCase()) {
                is Success -> _refreshState.value = GuardState.Authenticated
                is Error -> _refreshState.value = GuardState.Error(result.message)
                Loading -> _refreshState.value = GuardState.Loading
                Idle -> GuardState.Unauthenticated
            }
        }
    }
}