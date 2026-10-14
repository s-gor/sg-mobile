# SG-Mobile 083 / SG-Net integration staging

This branch contains **staging code**, not a working VPN engine or APK.

## Integration into the actual SG-Mobile Android application

1. Move `SgNetUriParser.kt` into the Android application's production source tree and the test into its JVM unit tests. Adjust the package declaration to match the application.
2. Register `sgnet://` in existing profile/link/subscription import dispatch. Persist `deviceId`, `secret`, `host`, `port`, `sni`, `version`, label; encrypt credential storage and redact logs/exports. Preserve source links and update semantics.
3. Supply a **real Android ARM64** SG-Net client build from the Go runtime matching SG-Gateway's deployed SG-Net/1 wire contract. Neither an SG-Net Windows .exe nor the design-only `s-gor/sg-net` repository is an Android runtime.
4. Route sing-box's existing TUN/DNS/per-app rules to a local SG-Net SOCKS outbound, and use SG-Net client for both TCP and UDP. Prevent routing SG-Net's own upstream socket back into the VPN; integrate Android `VpnService.protect()`/underlying network.
5. Start SG-Net before enabling traffic; detect runtime readiness and fail closed if unavailable. Stop/restart without leaving child processes or orphaned local port binds.
6. Verify TLS 1.3, certificate and hostname identity, device authorization, TCP/UDP, Wi-Fi to LTE handover, DNS leak, IPv4/IPv6, kill switch, and screen-off behavior. Keep existing 082 behavior unchanged.

## Current blockers

Public `sg-mobile` GitHub main currently publishes 082 release documentation, not its Gradle Android source tree. The legacy build branch is 079J and does not expose expected Gradle top-level files. Private `s-gor/sg-net` currently contains design/plan documents but no buildable Go client sources. Therefore no credible Android APK can be built from these two repositories alone.
