package cloud.hendra.danantara.presentation.ui.component.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar() {
    val materialColors = MaterialTheme.colorScheme
    var searchText by remember { mutableStateOf(TextFieldValue("")) }

    OutlinedTextField(
        value = searchText,
        onValueChange = { searchText = it },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text("Cari Barang...") },
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = materialColors.surfaceVariant,
            unfocusedContainerColor = materialColors.surfaceVariant,
            focusedBorderColor = materialColors.outline,
            unfocusedBorderColor = materialColors.outline
        ),
        shape = RoundedCornerShape(4.dp),
        textStyle = LocalTextStyle.current.copy(color = materialColors.onSurface)
    )
}