# Уведомления о сторонних компонентах

Этот репозиторий содержит документацию и релизные материалы SG Mobile, но не исходный код приложения.

Ниже перечислены основные сторонние компоненты тестовой линии 074P. Каждый компонент распространяется на условиях собственной лицензии.

| Компонент | Версия | Лицензия |
|---|---:|---|
| XTLS/libXray | 26.7.28 | MIT |
| XTLS/Xray-core | состав libXray | MPL-2.0 |
| enfein/mieru | 3.35.0 | GNU GPL v3 |
| MetaCubeX/mihomo | 1.19.29 | GNU GPL v3 |
| apernet/hysteria | 2.12.1 | MIT |
| SagerNet/sing-box | 1.14.0-beta.14 | GNU GPL v3 или более поздняя |
| amnezia-vpn/amneziawg-android | v3.1.20260814 | Apache License 2.0 |
| amnezia-vpn/amneziawg-go/v3 | 3.1.20260814 | MIT |
| AndroidX и Jetpack Compose | версия сборки | Apache License 2.0 |
| Kotlin и coroutines | версия сборки | Apache License 2.0 |
| AndroidX CameraX | версия сборки | Apache License 2.0 |
| ZXing Core | версия сборки | Apache License 2.0 |

## Зафиксированные SHA-256 движков

- libXray 26.7.28  
  `28b7dc9d6cc8455fcca5cbd56e387003a7bfb558128651a64899dc3a8ccff666`

- Mieru 3.35.0 Android ARM64  
  `53fd6a482122f964125434a7982583dc264a98e322b12882ec6a0c8fe632c3ad`

- Mihomo 1.19.29 Android ARM64  
  `ca44b51940fca5243f5099cf8c728bdfa86472af88a946265cf8f074fb2f0fe1`

- Hysteria2 2.12.1 Android ARM64  
  `92728ca71dee10508040939c0c99e69f8800519fcedb6ec35eed92b90f1b2a5f`

- sing-box 1.14.0-beta.14 Android ARM64 release archive  
  `411e4f0636c5201c77adcc6381444a549270d15ad84d3a82503d1b2c55ee80eb`

- AmneziaWG Android v3.1.20260814 AAR  
  `a4554bb5dcca2a8ebb94d6c4f9ebbf1fcc0d304795eddd2a12e1bcee0bdda22f`

## AmneziaWG

AAR AmneziaWG Android собран из официального тега `v3.1.20260814` репозитория `amnezia-vpn/amneziawg-android` с рекурсивно полученными upstream-зависимостями. В него входит официальный `amneziawg-go/v3 3.1.20260814`.

## libXray asset-location bridge

Линия libXray 26.7.28 использует upstream commit `80263da83e96b2972455b0a94b13ee1a10e51391` и минимальный Go bridge для установки и чтения Xray asset-location внутри того же Go runtime. Bridge не изменяет протокольную логику Xray.

## Необязательные данные маршрутизации

SG Mobile может загружать данные маршрутизации из публичных проектов:

- `GrimbirdUsers/ru-routing-dat`;
- `runetfreedom/russia-v2ray-rules-dat`.

Эти файлы загружаются отдельно и не считаются исходным кодом SG Mobile.

Полные тексты лицензий и необходимые материалы должны сопровождать тот публичный APK-релиз, к которому они относятся.
