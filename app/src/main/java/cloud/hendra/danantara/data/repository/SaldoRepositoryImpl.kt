package cloud.hendra.danantara.data.repository

import android.util.Log
import cloud.hendra.danantara.data.remote.SaldoService
import cloud.hendra.danantara.domain.model.SaldoRequest
import cloud.hendra.danantara.domain.model.SaldoResponse
import cloud.hendra.danantara.utils.state.ResultState

class SaldoRepositoryImpl(private val service: SaldoService) : SaldoRepository {
    override suspend fun openSaldo(saldo: SaldoRequest): ResultState<SaldoResponse> {
        return try {
            val response = service.openSaldo(saldo)
            if (response.isSuccessful) {
                ResultState.Success(response.body()!!)

            } else {
                ResultState.Error(response.message())
            }
        } catch (e: Exception) {
            ResultState.Error(e.message.toString())
        }
    }

    override suspend fun checkSaldo(): ResultState<SaldoResponse> {
        return try {
            val response = service.checkSaldo()
            if (response.isSuccessful) {
                ResultState.Success(response.body()!!)
            } else {
                Log.d("SaldoRepositoryImpl", "checkSaldo: ${response.body()}")
                ResultState.Error(response.message())
            }
        } catch (e: Exception) {
            ResultState.Error(e.message.toString())
        }
    }
}