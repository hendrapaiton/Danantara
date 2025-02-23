package cloud.hendra.danantara.domain.usecase.saldo

import cloud.hendra.danantara.data.repository.SaldoRepository
import cloud.hendra.danantara.domain.model.SaldoRequest

class OpenStoreUseCase(private val repository: SaldoRepository) {
    suspend operator fun invoke(shift: String, awal: Int) =
        repository.openSaldo(SaldoRequest(shift, awal))
}