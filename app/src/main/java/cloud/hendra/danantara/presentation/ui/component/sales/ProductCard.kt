package cloud.hendra.danantara.presentation.ui.component.sales

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProductCard() {
    val materialColors = MaterialTheme.colorScheme
    var initialText by remember { mutableStateOf("CD") }
    var quantityText by remember { mutableStateOf(TextFieldValue("0")) }
    var isFocused by remember { mutableStateOf(false) }

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
                        text = initialText.takeIf { it.isNotEmpty() }?.uppercase() ?: "",
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
                        value = quantityText,
                        onValueChange = { quantityText = it },
                        modifier = Modifier
                            .width(60.dp)
                            .background(
                                materialColors.surface,
                                shape = RoundedCornerShape(4.dp)
                            )
                            .border(
                                1.dp,
                                materialColors.outline,
                                shape = RoundedCornerShape(4.dp)
                            )
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                            .onFocusChanged { focusState ->
                                isFocused = focusState.isFocused
                                if (focusState.isFocused) {
                                    quantityText = quantityText.copy(
                                        selection = TextRange(0, quantityText.text.length)
                                    )
                                }
                            },
                        textStyle = LocalTextStyle.current.copy(
                            color = materialColors.onSurface,
                            textAlign = TextAlign.Right
                        ),
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                    )
                }
            }
        }
    }
}