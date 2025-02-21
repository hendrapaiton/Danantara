package cloud.hendra.danantara.utils.module

import cloud.hendra.danantara.domain.usecase.CheckUseCase
import cloud.hendra.danantara.domain.usecase.LoginUseCase
import org.koin.dsl.module

val usecaseModule = module {
    single { LoginUseCase(get()) }
    single { CheckUseCase(get()) }
}