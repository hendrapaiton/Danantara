package cloud.hendra.danantara.presentation.ui.component.common

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title: String, goToStock: () -> Unit, goToReport: () -> Unit) {
    val materialColors = MaterialTheme.colorScheme

    TopAppBar(
        title = {
            Text(
                title,
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold,
                color = materialColors.onPrimaryContainer
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = materialColors.primaryContainer,
            titleContentColor = materialColors.onPrimaryContainer,
            actionIconContentColor = materialColors.onPrimaryContainer
        ),
        actions = {
            var expanded by remember { mutableStateOf(false) }
            Box {
                IconButton(onClick = { expanded = true }) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "More"
                    )
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    DropdownMenuItem(
                        text = { Text("Stock") },
                        onClick = { goToStock() }
                    )
                    DropdownMenuItem(
                        text = { Text("Report") },
                        onClick = { goToReport() }
                    )
                    DropdownMenuItem(
                        text = { Text("Close") },
                        onClick = { }
                    )
                }
            }
        }
    )
}