package cloud.hendra.danantara.data.repository

import cloud.hendra.danantara.data.remote.AuthService
import cloud.hendra.danantara.domain.model.LoginRequest
import cloud.hendra.danantara.utils.authentication.AuthState

class AuthRepositoryImpl(
    private val service: AuthService
) : AuthRepository {
    override suspend fun cekToken(): AuthState {
        return try {
            val response = service.cekToken()
            when {
                response.isSuccessful -> AuthState.Success(response.body()!!)
                response.code() == 401 -> {
                    val response = service.refresh()
                    if (response.isSuccessful) {
                        AuthState.Success(response.body()!!)
                    } else {
                        AuthState.Error("Token refresh failed")
                    }
                }

                else -> AuthState.Error("Unexpected error: ${response.code()}")
            }
        } catch (e: Exception) {
            AuthState.Error(e.message.toString())
        }
    }

    override suspend fun login(
        username: String,
        password: String
    ): AuthState {
        return try {
            val response = service.login(LoginRequest(username, password))
            if (response.isSuccessful) {
                response.body()?.let {
                    AuthState.Success(it)
                } ?: AuthState.Error("Empty response body")
            } else {
                AuthState.Error("Login failed")
            }
        } catch (e: Exception) {
            AuthState.Error(e.message.toString())
        }
    }

    override suspend fun refresh(): AuthState {
        return try {
            val response = service.refresh()
            if (response.isSuccessful) {
                response.body()?.let {
                    AuthState.Success(it)
                } ?: AuthState.Error("Empty response body")
            } else {
                AuthState.Error("Token refresh failed")
            }
        } catch (e: Exception) {
            AuthState.Error(e.message.toString())
        }
    }
}