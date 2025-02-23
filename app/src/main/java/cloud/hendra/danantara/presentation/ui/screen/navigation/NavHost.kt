package cloud.hendra.danantara.presentation.ui.screen.navigation

import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import cloud.hendra.danantara.presentation.ui.screen.LoadingScreen
import cloud.hendra.danantara.presentation.ui.screen.LoginPage
import cloud.hendra.danantara.presentation.ui.screen.ReportPage
import cloud.hendra.danantara.presentation.ui.screen.SalesPage
import cloud.hendra.danantara.presentation.ui.screen.StockPage
import cloud.hendra.danantara.presentation.ui.screen.navigation.Routes.LOADING
import cloud.hendra.danantara.presentation.ui.screen.navigation.Routes.LOGIN_PAGE
import cloud.hendra.danantara.presentation.ui.screen.navigation.Routes.REPORT_PAGE
import cloud.hendra.danantara.presentation.ui.screen.navigation.Routes.SALES_PAGE
import cloud.hendra.danantara.presentation.ui.screen.navigation.Routes.STOCK_PAGE
import cloud.hendra.danantara.presentation.viewmodel.AuthViewModel
import cloud.hendra.danantara.utils.state.GuardState
import org.koin.androidx.compose.koinViewModel

@Composable
fun AuthNavHost(
    navController: NavHostController,
    authViewModel: AuthViewModel = koinViewModel()
) {
    val authState by authViewModel.authState.collectAsState()
    val startDestination = remember { LOADING }

    LaunchedEffect(Unit) {
        authViewModel.check()
    }

    LaunchedEffect(authState) {
        when (authState) {
            is GuardState.Authenticated -> navController.navigate(SALES_PAGE)
            is GuardState.Unauthenticated -> navController.navigate(LOGIN_PAGE)
            is GuardState.Error -> navController.navigate(LOGIN_PAGE)
            else -> {
                authViewModel.check()
                navController.navigate(LOADING)
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(LOADING) {
            LoadingScreen()
        }
        composable(LOGIN_PAGE) {
            LoginPage(
                onLoginSuccess = {
                    navController.navigate(SALES_PAGE) {
                        popUpTo(LOGIN_PAGE) { inclusive = true }
                    }
                }
            )
        }

        composable(SALES_PAGE) {
            SalesPage(
                goToStock = {
                    navController.navigate(STOCK_PAGE) {
                        popUpTo(SALES_PAGE) { inclusive = true }
                    }
                },
                goToReport = {
                    navController.navigate(REPORT_PAGE) {
                        popUpTo(SALES_PAGE) { inclusive = true }
                    }
                }
            )
        }

        composable(STOCK_PAGE) {
            StockPage()
        }

        composable(REPORT_PAGE) {
            ReportPage()
        }
    }
}