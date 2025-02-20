package cloud.hendra.danantara.utils.authentication

import cloud.hendra.danantara.domain.model.LoginResponse

interface TokenManager {
    fun getAccessToken(): String?
    fun saveAccessToken(access: LoginResponse)
    fun clearAccessToken()
    fun getRefreshToken(): String?
    fun saveRefreshToken(refresh: String)
}