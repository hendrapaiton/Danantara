package cloud.hendra.danantara.domain.usecase.auth

import cloud.hendra.danantara.data.repository.AuthRepository

class LoginUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(username: String, password: String) = repository.login(username, password)
}