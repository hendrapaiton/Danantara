package cloud.hendra.danantara.utils.module

import cloud.hendra.danantara.data.remote.AuthService
import cloud.hendra.danantara.data.remote.SaldoService
import cloud.hendra.danantara.utils.authentication.SecureTokenManager
import cloud.hendra.danantara.utils.authentication.TokenManager
import org.koin.dsl.module
import retrofit2.Retrofit

val serviceModule = module {
    single<TokenManager> { SecureTokenManager(get()) }
    single<AuthService> { get<Retrofit>().create(AuthService::class.java) }
    single<SaldoService> { get<Retrofit>().create(SaldoService::class.java) }
}