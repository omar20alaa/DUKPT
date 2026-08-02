package app.dukpt.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
 fun Buttons(
    onGenerate: () -> Unit,
    onClear: () -> Unit
) {

    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Button(
            modifier = Modifier.weight(1f),
            onClick = onGenerate
        ) {

            Text("Encrypt")

        }

        OutlinedButton(
            modifier = Modifier.weight(1f),
            onClick = onClear
        ) {

            Text("Clear")

        }

    }

}