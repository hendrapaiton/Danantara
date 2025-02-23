package cloud.hendra.danantara.presentation.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cloud.hendra.danantara.presentation.ui.component.common.SearchBar
import cloud.hendra.danantara.presentation.ui.component.common.TopBar
import cloud.hendra.danantara.presentation.ui.component.sales.ProductCard
import cloud.hendra.danantara.presentation.ui.component.sales.TotalAction

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SalesPage() {
    val materialColors = MaterialTheme.colorScheme

    Scaffold(
        topBar = {
            TopBar(title = "Sales")
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp)
                .fillMaxSize()
                .background(materialColors.background),
        ) {
            SearchBar()
            Spacer(modifier = Modifier.height(16.dp))
            ProductCard()
            Spacer(modifier = Modifier.height(16.dp))
            TotalAction()
        }
    }
}