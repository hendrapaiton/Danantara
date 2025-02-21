package cloud.hendra.danantara.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cloud.hendra.danantara.domain.usecase.CheckUseCase
import cloud.hendra.danantara.domain.usecase.LoginUseCase
import cloud.hendra.danantara.domain.usecase.RefreshUseCase
import cloud.hendra.danantara.utils.authentication.AuthState.*
import cloud.hendra.danantara.utils.state.GuardState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel(
    private val loginUseCase: LoginUseCase,
    private val checkUseCase: CheckUseCase,
) : ViewModel() {
    private val _authState = MutableStateFlow<GuardState>(GuardState.Unauthenticated)
    val authState: StateFlow<GuardState> = _authState

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

    fun check() {
        viewModelScope.launch {
            _authState.value = GuardState.Loading
            when (val result = checkUseCase()) {
                is Success -> _authState.value = GuardState.Authenticated
                is Error -> _authState.value = GuardState.Error(result.message)
                is Loading -> _authState.value = GuardState.Loading
                else -> _authState.value = GuardState.Unauthenticated
            }
        }
    }
}