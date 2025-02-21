package cloud.hendra.danantara.presentation.ui.screen.navigation

import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import cloud.hendra.danantara.presentation.ui.screen.LoginPage
import cloud.hendra.danantara.presentation.ui.screen.ReportPage
import cloud.hendra.danantara.presentation.ui.screen.SaldoPage
import cloud.hendra.danantara.presentation.ui.screen.SalesPage
import cloud.hendra.danantara.presentation.ui.screen.StockPage
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

    LaunchedEffect(Unit) {
        authViewModel.check()
    }

    val startDestination = remember(authState) {
        if (authState is GuardState.Authenticated) SALDO_PAGE else LOGIN_PAGE
    }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
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
            if (authState !is GuardState.Authenticated) {
                LaunchedEffect(Unit) {
                    navController.navigate(LOGIN_PAGE) {
                        popUpTo(LOGIN_PAGE) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            } else {
                SaldoPage()
            }
        }

        composable(SALES_PAGE) {
            if (authState !is GuardState.Authenticated) {
                LaunchedEffect(Unit) {
                    navController.navigate(LOGIN_PAGE) {
                        popUpTo(LOGIN_PAGE) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            } else {
                SalesPage()
            }
        }

        composable(STOCK_PAGE) {
            if (authState !is GuardState.Authenticated) {
                LaunchedEffect(Unit) {
                    navController.navigate(LOGIN_PAGE) {
                        popUpTo(LOGIN_PAGE) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            } else {
                StockPage()
            }
        }

        composable(REPORT_PAGE) {
            if (authState !is GuardState.Authenticated) {
                LaunchedEffect(Unit) {
                    navController.navigate(LOGIN_PAGE) {
                        popUpTo(LOGIN_PAGE) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            } else {
                ReportPage()
            }
        }
    }
}