package app.dukpt.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
 fun ResultSection(
    state: HomeUiState
) {

    if (state.isLoading) {

        CircularProgressIndicator()

        return
    }

    if (state.errorMessage != null) {

        Text(
            text = state.errorMessage,
            color = MaterialTheme.colorScheme.error
        )

        return
    }

    if (!state.isSuccess)
        return

    ElevatedCard {

        Column(
            Modifier.padding(20.dp)
        ) {

            Text(
                "Transaction Key",
                fontWeight = FontWeight.Bold
            )

            Text(state.transactionKey)

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                "Encrypted",
                fontWeight = FontWeight.Bold
            )

            Text(state.encryptedData)

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                "Decrypted",
                fontWeight = FontWeight.Bold
            )

            Text(state.decryptedData)

        }

    }

}