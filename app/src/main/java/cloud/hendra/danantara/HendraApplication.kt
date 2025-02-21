package cloud.hendra.danantara

import android.app.Application
import cloud.hendra.danantara.utils.module.networkModule
import cloud.hendra.danantara.utils.module.repositoryModule
import cloud.hendra.danantara.utils.module.serviceModule
import cloud.hendra.danantara.utils.module.usecaseModule
import cloud.hendra.danantara.utils.module.viewmodelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class HendraApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@HendraApplication)
            modules(
                listOf(
                    networkModule,
                    serviceModule,
                    usecaseModule,
                    repositoryModule,
                    viewmodelModule,
                )
            )
        }
    }
}