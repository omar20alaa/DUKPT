package app.dukpt.presentation.home


data class HomeUiState(

    val bdk: String = "0123456789ABCDEFFEDCBA9876543210",

    val ksn: String = "FFFF9876543210E00008",

    val plainText: String = "Encrypt with DUKPT",

    val transactionKey: String = "",

    val encryptedData: String = "",

    val decryptedData: String = "",

    val isLoading: Boolean = false,

    val isSuccess: Boolean = false,

    val errorMessage: String? = null
)