package cloud.hendra.danantara

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import cloud.hendra.danantara.presentation.ui.screen.navigation.AuthNavHost
import cloud.hendra.danantara.presentation.ui.screen.navigation.Routes.SALDO_PAGE
import cloud.hendra.danantara.presentation.ui.theme.DanantaraTheme
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            DanantaraTheme {
                AuthNavHost(
                    navController = navController,
                    authViewModel = getViewModel()
                )
            }
        }
    }
}