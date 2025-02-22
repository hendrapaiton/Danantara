package cloud.hendra.danantara.data.repository

import cloud.hendra.danantara.domain.model.SaldoRequest
import cloud.hendra.danantara.domain.model.SaldoResponse
import cloud.hendra.danantara.utils.state.ResultState

interface SaldoRepository {
    suspend fun openSaldo(saldo: SaldoRequest): ResultState<SaldoResponse>
    suspend fun checkSaldo(): ResultState<SaldoResponse>
}