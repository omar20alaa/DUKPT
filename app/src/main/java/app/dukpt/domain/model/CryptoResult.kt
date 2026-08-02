package app.dukpt.domain.model

data class CryptoResult(
    val transactionKey: String,
    val encrypted: String,
    val decrypted: String
)