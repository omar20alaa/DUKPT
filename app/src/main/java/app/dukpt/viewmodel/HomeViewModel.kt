package app.dukpt.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.dukpt.domain.repository.CryptoRepository
import app.dukpt.presentation.home.HomeEvent
import app.dukpt.presentation.home.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: CryptoRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun onEvent(event: HomeEvent) {
        when (event) {

            is HomeEvent.BdkChanged -> {
                _uiState.update {
                    it.copy(bdk = event.value)
                }
            }

            is HomeEvent.KsnChanged -> {
                _uiState.update {
                    it.copy(ksn = event.value)
                }
            }

            is HomeEvent.PlainTextChanged -> {
                _uiState.update {
                    it.copy(plainText = event.value)
                }
            }

            HomeEvent.GenerateClicked -> {
                encryptAndDecrypt()
            }

            HomeEvent.ClearClicked -> {
                clear()
            }
        }
    }

    private fun encryptAndDecrypt() {

        val state = _uiState.value

        if (state.bdk.isBlank()) {
            showError("BDK is required")
            return
        }

        if (state.ksn.isBlank()) {
            showError("KSN is required")
            return
        }

        if (state.plainText.isBlank()) {
            showError("Please enter text to encrypt")
            return
        }

        viewModelScope.launch {

            _uiState.update {
                it.copy(
                    isLoading = true,
                    isSuccess = false,
                    errorMessage = null
                )
            }

            delay(700)

            try {

                val result = repository.encrypt(
                    bdk = state.bdk,
                    ksn = state.ksn,
                    plainText = state.plainText
                )

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        isSuccess = true,
                        transactionKey = result.transactionKey,
                        encryptedData = result.encrypted,
                        decryptedData = result.decrypted
                    )
                }

            } catch (e: Exception) {

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        isSuccess = false,
                        errorMessage = e.message ?: "Encryption failed"
                    )
                }
            }
        }
    }

    private fun showError(message: String) {
        _uiState.update {
            it.copy(
                errorMessage = message,
                isSuccess = false
            )
        }
    }


    private fun clear() {
        _uiState.value = HomeUiState()
    }
}