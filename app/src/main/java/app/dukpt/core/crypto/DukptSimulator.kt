package app.dukpt.core.crypto

import app.dukpt.domain.model.CryptoResult
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

class DukptSimulator {
    fun encrypt(
        bdk: String,
        ksn: String,
        plainText: String
    ): CryptoResult {
        val key = deriveKey(bdk, ksn)
        val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
        cipher.init(
            Cipher.ENCRYPT_MODE,
            SecretKeySpec(key, "AES")
        )
        val encryptedBytes =
            cipher.doFinal(plainText.toByteArray())
        val encryptedHex =
            HexUtils.bytesToHex(encryptedBytes)
        cipher.init(
            Cipher.DECRYPT_MODE,
            SecretKeySpec(key, "AES")
        )
        val decrypted =
            String(
                cipher.doFinal(encryptedBytes)
            )

        return CryptoResult(
            transactionKey = HexUtils.bytesToHex(key),
            encrypted = encryptedHex,
            decrypted = decrypted
        )
    }
    private fun deriveKey(
        bdk: String,
        ksn: String
    ): ByteArray {

        val hash = HashUtils.sha256(
            (bdk + ksn).toByteArray()
        )

        return hash.copyOfRange(0, 16)
    }
}