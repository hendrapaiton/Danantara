package cloud.hendra.danantara.presentation.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SalesPage() {
    val materialColors = MaterialTheme.colorScheme
    var searchText = remember { mutableStateOf(TextFieldValue("Cari Barang...")) }
    var initialText = remember { mutableStateOf(TextFieldValue("CD")) }
    var quantityText = remember { mutableStateOf(TextFieldValue("0")) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Sales",
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
                                text = { Text("Export Data") },
                                onClick = { }
                            )
                            DropdownMenuItem(
                                text = { Text("Settings") },
                                onClick = { }
                            )
                        }
                    }
                }
            )
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
            BasicTextField(
                value = searchText.value,
                onValueChange = { searchText.value = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        materialColors.surfaceVariant,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .border(
                        1.dp,
                        materialColors.outline,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .padding(8.dp),
                textStyle = LocalTextStyle.current.copy(color = materialColors.onSurface)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = materialColors.surfaceVariant
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier.weight(0.2f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .size(70.dp)
                                .background(
                                    materialColors.primaryContainer,
                                    shape = RoundedCornerShape(8.dp)
                                )
                        ) {
                            Text(
                                text = initialText.value.text.takeIf { it.isNotEmpty() }
                                    ?.uppercase() ?: "",
                                fontSize = 20.sp,
                                color = materialColors.onPrimaryContainer
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .weight(0.8f)
                            .padding(start = 16.dp)
                    ) {
                        Text(
                            text = "Nama Barang".uppercase(),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = materialColors.onSurface
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                "Rp. 18.000",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = materialColors.primary
                            )
                            IconButton(onClick = {}) {
                                Icon(
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = "",
                                    tint = materialColors.onSurface
                                )
                            }
                            BasicTextField(
                                value = quantityText.value,
                                onValueChange = { quantityText.value = it },
                                modifier = Modifier
                                    .width(80.dp)
                                    .background(
                                        materialColors.surface,
                                        shape = RoundedCornerShape(4.dp)
                                    )
                                    .border(
                                        1.dp,
                                        materialColors.outline,
                                        shape = RoundedCornerShape(4.dp)
                                    )
                                    .padding(8.dp),
                                textStyle = LocalTextStyle.current.copy(
                                    color = materialColors.onSurface
                                )
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = materialColors.surfaceVariant
                )
            ) {
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row {
                        Button(
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = materialColors.primary,
                                contentColor = materialColors.onPrimary
                            )
                        ) {
                            Text("Cash")
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        Button(
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = materialColors.secondary,
                                contentColor = materialColors.onSecondary
                            )
                        ) {
                            Text("Qris")
                        }
                    }

                    Column {
                        Text(
                            text = "Total",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.ExtraLight,
                            color = materialColors.onSurfaceVariant
                        )
                        Text(
                            text = "Rp. 200.000",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = materialColors.primary
                        )
                    }
                }
            }
        }
    }
}