package cloud.hendra.danantara.data.remote

import cloud.hendra.danantara.domain.model.LoginRequest
import cloud.hendra.danantara.domain.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthService {
    @POST("api/v1/token/")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @POST("api/v1/token/refresh/")
    suspend fun refresh(): Response<LoginResponse>

    @GET("api/v1/protected/")
    suspend fun cekToken(): Response<LoginResponse>
}