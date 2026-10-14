package sg.mobile.sgnet

import org.junit.Assert.*
import org.junit.Test

class SgNetUriParserTest {
    @Test fun importsGatewayUri() {
        val p = SgNetUriParser.parse(
            "sgnet://gateway.example:443?device_id=device-2&secret=c2VjcmV0PQ%3D%3D&sni=gateway.example&v=1#Mobile")
        assertEquals("gateway.example", p.host)
        assertEquals(443, p.port)
        assertEquals("device-2", p.deviceId)
        assertEquals("c2VjcmV0PQ==", p.secret)
        assertEquals("Mobile", p.name)
    }

    @Test fun doesNotLeakCredentialsViaToString() {
        val p = SgNetUriParser.parse("sgnet://gateway.example:443?device_id=private-id&secret=private-secret")
        assertFalse(p.toString().contains("private-id"))
        assertFalse(p.toString().contains("private-secret"))
    }

    @Test fun rejectsDuplicateSecret() {
        assertInvalid("sgnet://gateway.example:443?device_id=d&secret=x&secret=y")
    }

    @Test fun rejectsMissingCredential() {
        assertInvalid("sgnet://gateway.example:443?device_id=d")
    }

    @Test fun rejectsOtherSchemeAndInvalidPort() {
        assertInvalid("https://gateway.example:443?device_id=d&secret=s")
        assertInvalid("sgnet://gateway.example?device_id=d&secret=s")
    }

    @Test fun rejectsUnsupportedVersion() {
        assertInvalid("sgnet://gateway.example:443?device_id=d&secret=s&v=2")
    }

    private fun assertInvalid(uri: String) {
        try {
            SgNetUriParser.parse(uri)
            fail("Expected IllegalArgumentException")
        } catch (_: IllegalArgumentException) { }
    }
}
