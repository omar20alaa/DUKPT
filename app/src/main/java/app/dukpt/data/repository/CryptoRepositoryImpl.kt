package app.dukpt.data.repository

import app.dukpt.core.crypto.DukptSimulator
import app.dukpt.domain.model.CryptoResult
import app.dukpt.domain.repository.CryptoRepository
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class CryptoRepositoryImpl @Inject constructor(
    private val simulator: DukptSimulator
) : CryptoRepository {
    override fun encrypt(
        bdk: String,
        ksn: String,
        plainText: String
    ): CryptoResult {
        return simulator.encrypt(
            bdk,
            ksn,
            plainText
        )
    }
}