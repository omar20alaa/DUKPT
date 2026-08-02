package app.dukpt.presentation.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
 fun InputSection(
    state: HomeUiState,
    onEvent: (HomeEvent) -> Unit
) {

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = state.bdk,
        onValueChange = {
            onEvent(HomeEvent.BdkChanged(it))
        },
        label = {
            Text("BDK")
        }
    )

    Spacer(modifier = Modifier.height(12.dp))

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = state.ksn,
        onValueChange = {
            onEvent(HomeEvent.KsnChanged(it))
        },
        label = {
            Text("KSN")
        }
    )

    Spacer(modifier = Modifier.height(12.dp))

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = state.plainText,
        onValueChange = {
            onEvent(HomeEvent.PlainTextChanged(it))
        },
        label = {
            Text("Plain Text")
        }
    )

}