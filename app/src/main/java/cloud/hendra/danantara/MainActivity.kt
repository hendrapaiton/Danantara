package cloud.hendra.danantara

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import cloud.hendra.danantara.presentation.ui.screen.navigation.AuthNavHost
import cloud.hendra.danantara.presentation.ui.theme.DanantaraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            DanantaraTheme {
                AuthNavHost(
                    navController = navController
                )
            }
        }
    }
}