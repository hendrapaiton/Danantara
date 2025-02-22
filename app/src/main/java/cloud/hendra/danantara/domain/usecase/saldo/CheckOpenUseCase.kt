package cloud.hendra.danantara.domain.usecase.saldo

import cloud.hendra.danantara.data.repository.SaldoRepository

class CheckOpenUseCase(private val repository: SaldoRepository) {
    suspend operator fun invoke() = repository.checkSaldo()
}