package app.dukpt.core.crypto

object HexUtils {

    fun hexToBytes(hex: String): ByteArray {
        val clean = hex.replace(" ", "")
        require(clean.length % 2 == 0) {
            "Invalid hex string"
        }
        return ByteArray(clean.length / 2).apply {
            for (i in indices) {
                val index = i * 2
                this[i] = clean.substring(index, index + 2).toInt(16).toByte()
            }
        }
    }
    fun bytesToHex(bytes: ByteArray): String {
        return bytes.joinToString("") {
            "%02X".format(it)
        }
    }
}