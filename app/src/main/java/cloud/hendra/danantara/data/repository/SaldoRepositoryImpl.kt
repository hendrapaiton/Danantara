package cloud.hendra.danantara.data.repository

import cloud.hendra.danantara.data.remote.SaldoService
import cloud.hendra.danantara.domain.model.SaldoRequest
import cloud.hendra.danantara.domain.model.SaldoResponse
import cloud.hendra.danantara.utils.state.ResultState

class SaldoRepositoryImpl(
    private val saldoService: SaldoService
) : SaldoRepository {
    override suspend fun openSaldo(saldo: SaldoRequest): ResultState<SaldoResponse> {
        return try {
            val response = saldoService.openSaldo(saldo)
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
            val response = saldoService.checkSaldo()
            if (response.isSuccessful) {
                ResultState.Success(response.body()!!)
            } else {
                ResultState.Error(response.message())
            }
        } catch (e: Exception) {
            ResultState.Error(e.message.toString())
        }
    }
}