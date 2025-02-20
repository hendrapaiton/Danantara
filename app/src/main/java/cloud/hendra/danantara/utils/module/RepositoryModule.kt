package cloud.hendra.danantara.utils.module

import cloud.hendra.danantara.data.repository.AuthRepository
import cloud.hendra.danantara.data.repository.AuthRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<AuthRepository> { AuthRepositoryImpl(get()) }
}