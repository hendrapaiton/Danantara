package cloud.hendra.danantara.utils.authentication

import cloud.hendra.danantara.domain.model.LoginResponse

sealed class AuthState {
    object Idle : AuthState()
    object Loading : AuthState()
    data class Success(val token: LoginResponse) : AuthState()
    data class Error(val message: String) : AuthState()
}