package sg.mobile.sgnet

import java.net.URI
import java.net.URLDecoder

/**
 * Pure Android/JVM SG-Net subscription URI parser.
 * IMPORTANT: credentials must not be written to logs, analytics, or exception text.
 */
data class SgNetProfile(
    val host: String,
    val port: Int,
    val deviceId: String,
    val secret: String,
    val sni: String,
    val version: Int,
    val name: String
) {
    override fun toString(): String =
        "SgNetProfile(host=[redacted],port=$port,deviceId=[redacted],secret=[redacted],sni=[redacted],version=$version)"
}

object SgNetUriParser {
    fun parse(raw: String): SgNetProfile {
        require(raw.length <= 8192) { "SG-Net URI too long" }
        val uri = try { URI(raw.trim()) } catch (_: Exception) {
            throw IllegalArgumentException("Invalid SG-Net URI")
        }
        require(uri.scheme.equals("sgnet", ignoreCase = true)) { "Not an SG-Net URI" }
        require(uri.rawUserInfo == null) { "Credentials in authority not supported" }
        val host = uri.host?.takeIf { it.isNotBlank() }
            ?: throw IllegalArgumentException("Missing SG-Net host")
        require(!host.contains('%')) { "Invalid SG-Net host" }
        val port = uri.port
        require(port in 1..65535) { "Invalid SG-Net port" }
        val params = linkedMapOf<String, String>()
        val query = uri.rawQuery ?: ""
        if (query.isNotEmpty()) for (pair in query.split('&')) {
            val idx = pair.indexOf('=')
            require(idx > 0) { "Malformed SG-Net parameter" }
            val key = decode(pair.substring(0, idx))
            val value = decode(pair.substring(idx + 1))
            require(!params.containsKey(key)) { "Duplicate SG-Net parameter" }
            params[key] = value
        }
        val deviceId = params["device_id"]?.takeIf { it.isNotBlank() }
            ?: throw IllegalArgumentException("Missing device ID")
        val secret = params["secret"]?.takeIf { it.isNotBlank() }
            ?: throw IllegalArgumentException("Missing device credential")
        require(deviceId.length <= 256 && secret.length <= 2048) { "Invalid credential length" }
        val sni = params["sni"]?.takeIf { it.isNotBlank() } ?: host
        require(sni.length <= 253 && !sni.any { it.isWhitespace() || it == '/' })
        val version = if (params.containsKey("v")) params["v"]?.toIntOrNull()
            ?: throw IllegalArgumentException("Invalid SG-Net profile version") else 1
        require(version == 1) { "Unsupported SG-Net profile version" }
        val name = decode(uri.rawFragment ?: "").take(128).ifBlank { "SG-Net" }
        return SgNetProfile(host, port, deviceId, secret, sni, version, name)
    }

    private fun decode(value: String): String = try {
        URLDecoder.decode(value.replace("+", "%2B"), "UTF-8")
    } catch (_: Exception) {
        throw IllegalArgumentException("Malformed SG-Net encoding")
    }
}
