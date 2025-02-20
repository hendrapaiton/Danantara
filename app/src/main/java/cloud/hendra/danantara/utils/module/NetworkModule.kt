package cloud.hendra.danantara.utils.module

import cloud.hendra.danantara.utils.Constants.BASE_URL
import cloud.hendra.danantara.utils.authentication.AuthInterceptor
import cloud.hendra.danantara.utils.authentication.ServerCookieJar
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { ServerCookieJar(get()) }

    single<OkHttpClient> {
        OkHttpClient.Builder()
            .cookieJar(ServerCookieJar(get()))
            .addInterceptor(
                AuthInterceptor(
                    tokenManager = get(),
                    excludedPaths = setOf(
                        "/api/v1/",
                        "/api/v1/token/",
                        "/api/v1/token/refresh/"
                    )
                )
            )
            .addInterceptor(HttpLoggingInterceptor().setLevel(Level.BODY))
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}


