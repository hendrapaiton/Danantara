package cloud.hendra.danantara.utils.module

import cloud.hendra.danantara.domain.usecase.auth.CheckUseCase
import cloud.hendra.danantara.domain.usecase.auth.LoginUseCase
import cloud.hendra.danantara.domain.usecase.saldo.CheckOpenUseCase
import cloud.hendra.danantara.domain.usecase.saldo.OpenStoreUseCase
import org.koin.dsl.module

val usecaseModule = module {
    single { LoginUseCase(get()) }
    single { CheckUseCase(get()) }
    single { CheckOpenUseCase(get()) }
    single { OpenStoreUseCase(get()) }
}