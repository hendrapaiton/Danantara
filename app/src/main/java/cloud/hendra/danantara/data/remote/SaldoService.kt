package cloud.hendra.danantara.data.remote

import cloud.hendra.danantara.domain.model.SaldoRequest
import cloud.hendra.danantara.domain.model.SaldoResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface SaldoService {
    @POST("api/v1/open/")
    suspend fun openSaldo(@Body saldo: SaldoRequest): Response<SaldoResponse>

    @GET("api/v1/open/")
    suspend fun checkSaldo(): Response<SaldoResponse>
}