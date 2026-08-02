package app.dukpt.core.crypto

import java.security.MessageDigest

object HashUtils {
    fun sha256(data: ByteArray): ByteArray {
        return MessageDigest
            .getInstance("SHA-256")
            .digest(data)
    }
}