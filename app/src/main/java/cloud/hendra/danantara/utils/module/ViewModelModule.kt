package cloud.hendra.danantara.utils.module

import cloud.hendra.danantara.presentation.viewmodel.AuthViewModel
import cloud.hendra.danantara.presentation.viewmodel.SaldoViewModel
import org.koin.dsl.module

val viewmodelModule = module {
    single { AuthViewModel(get(), get(), get()) }
    single { SaldoViewModel(get()) }
}