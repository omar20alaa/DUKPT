package app.dukpt.domain.repository

import app.dukpt.domain.model.CryptoResult


interface CryptoRepository {
    fun encrypt(
        bdk: String,
        ksn: String,
        plainText: String
    ): CryptoResult
}