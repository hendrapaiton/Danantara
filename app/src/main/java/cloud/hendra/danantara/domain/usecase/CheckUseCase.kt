package cloud.hendra.danantara.domain.usecase

import cloud.hendra.danantara.data.repository.AuthRepository

class CheckUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke() = repository.cekToken()
}