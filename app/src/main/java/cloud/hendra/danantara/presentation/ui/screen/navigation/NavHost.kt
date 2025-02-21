package cloud.hendra.danantara.presentation.ui.screen.navigation

import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import cloud.hendra.danantara.presentation.ui.screen.LoadingScreen
import cloud.hendra.danantara.presentation.ui.screen.LoginPage
import cloud.hendra.danantara.presentation.ui.screen.ReportPage
import cloud.hendra.danantara.presentation.ui.screen.SaldoPage
import cloud.hendra.danantara.presentation.ui.screen.SalesPage
import cloud.hendra.danantara.presentation.ui.screen.StockPage
import cloud.hendra.danantara.presentation.ui.screen.navigation.Routes.LOADING
import cloud.hendra.danantara.presentation.ui.screen.navigation.Routes.LOGIN_PAGE
import cloud.hendra.danantara.presentation.ui.screen.navigation.Routes.REPORT_PAGE
import cloud.hendra.danantara.presentation.ui.screen.navigation.Routes.SALDO_PAGE
import cloud.hendra.danantara.presentation.ui.screen.navigation.Routes.SALES_PAGE
import cloud.hendra.danantara.presentation.ui.screen.navigation.Routes.STOCK_PAGE
import cloud.hendra.danantara.presentation.viewmodel.AuthViewModel
import cloud.hendra.danantara.utils.state.GuardState

@Composable
fun AuthNavHost(
    navController: NavHostController,
    authViewModel: AuthViewModel
) {
    val authState by authViewModel.authState.collectAsState()
    val startDestination = remember { LOADING }

    LaunchedEffect(Unit) {
        authViewModel.check()
    }

    LaunchedEffect(authState) {
        when (authState) {
            is GuardState.Authenticated -> navController.navigate(SALDO_PAGE)
            is GuardState.Unauthenticated -> navController.navigate(LOGIN_PAGE)
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
                    navController.navigate(SALDO_PAGE) {
                        popUpTo(LOGIN_PAGE) { inclusive = true }
                    }
                }
            )
        }

        composable(SALDO_PAGE) {
            SaldoPage()
        }

        composable(SALES_PAGE) {
            SalesPage()
        }

        composable(STOCK_PAGE) {
            StockPage()
        }

        composable(REPORT_PAGE) {
            ReportPage()
        }
    }
}