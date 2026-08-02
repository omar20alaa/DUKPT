package app.dukpt.presentation.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    state: HomeUiState,
    onEvent: (HomeEvent) -> Unit
) {

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        item {
            Header()
        }

        item {
            InputSection(
                state = state,
                onEvent = onEvent
            )
        }

        item {
            Buttons(
                onGenerate = {
                    onEvent(HomeEvent.GenerateClicked)
                },
                onClear = {
                    onEvent(HomeEvent.ClearClicked)
                }
            )
        }

        item {

            AnimatedVisibility(visible = state.isLoading) {
                LinearProgressIndicator(
                    modifier = Modifier.fillMaxWidth()
                )
            }

        }

        if (state.isSuccess) {

            item {
                ResultCard(
                    title = "Transaction Key",
                    value = state.transactionKey,
                )
            }

            item {
                ResultCard(
                    title = "Encrypted Data",
                    value = state.encryptedData,
                )
            }

            item {
                ResultCard(
                    title = "Decrypted Data",
                    value = state.decryptedData,
                )
            }

        }

    }

}