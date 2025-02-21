package cloud.hendra.danantara.data.repository

import cloud.hendra.danantara.utils.authentication.AuthState

interface AuthRepository {
    suspend fun cekToken(): AuthState
    suspend fun login(username: String, password: String): AuthState
    suspend fun refresh(): AuthState
}