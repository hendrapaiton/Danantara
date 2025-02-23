package cloud.hendra.danantara.presentation.ui.component.sales

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TotalAction() {
    val materialColors = MaterialTheme.colorScheme

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
                    text = "Total Keseluruhan".uppercase(),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light,
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