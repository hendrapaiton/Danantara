package cloud.hendra.danantara.presentation.ui.screen

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import cloud.hendra.danantara.presentation.ui.component.saldo.MainScreen
import cloud.hendra.danantara.presentation.viewmodel.SaldoViewModel
import cloud.hendra.danantara.utils.state.ResultState
import org.koin.androidx.compose.koinViewModel

@Composable
fun SaldoPage(
    viewModel: SaldoViewModel = koinViewModel(),
    onOpenStore: () -> Unit
) {
    val state = viewModel.saldo.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.checkSaldo()
    }

    when (val result = state.value) {
        is ResultState.Initial -> Unit
        is ResultState.Loading -> {
            LoadingScreen()
        }

        is ResultState.Success -> {
            if (result.data.hasOpenSaldo) {
                onOpenStore()
            } else {
                MainScreen(onOpenStore = onOpenStore)
            }
        }

        is ResultState.Error -> {
            ResultState.Initial
        }
    }
}