<div align="center">

# SG Mobile 075

### Универсальный VPN-клиент для Android

**Один APK. Несколько сетевых движков. Профили, подписки, маршрутизация, мониторинг и защита от утечек — в одном интерфейсе.**

<p>
  <img alt="Release line" src="https://img.shields.io/badge/Release%20line-075-2563EB?style=for-the-badge">
  <img alt="Status" src="https://img.shields.io/badge/Status-Testing-F59E0B?style=for-the-badge">
  <img alt="Android" src="https://img.shields.io/badge/Android-8.0%2B-3DDC84?style=for-the-badge&logo=android&logoColor=white">
  <img alt="ABI" src="https://img.shields.io/badge/ABI-arm64--v8a-5865F2?style=for-the-badge">
</p>

<p>
  <img alt="Xray" src="https://img.shields.io/badge/Xray-libXray-2563EB?style=flat-square">
  <img alt="sing-box" src="https://img.shields.io/badge/sing--box-supported-0EA5E9?style=flat-square">
  <img alt="Hysteria2" src="https://img.shields.io/badge/Hysteria2-supported-8B5CF6?style=flat-square">
  <img alt="Mieru" src="https://img.shields.io/badge/Mieru-supported-7C3AED?style=flat-square">
  <img alt="Mihomo" src="https://img.shields.io/badge/Mihomo-supported-6366F1?style=flat-square">
  <img alt="AmneziaWG" src="https://img.shields.io/badge/AmneziaWG-AWG%202.0%20%7C%203.0%20%7C%203.1-6D5BD0?style=flat-square">
</p>

<p>
  <a href="../../releases"><img alt="Releases" src="https://img.shields.io/badge/RELEASES-ОТКРЫТЬ-2F6B57?style=for-the-badge"></a>
  <a href="HELP-RU.md"><img alt="Русская справка" src="https://img.shields.io/badge/СПРАВКА-РУССКАЯ-0EA5E9?style=for-the-badge"></a>
  <a href="../../issues"><img alt="Сообщить об ошибке" src="https://img.shields.io/badge/ISSUES-СООБЩИТЬ-6B7280?style=for-the-badge"></a>
</p>

</div>

---

## Текущий статус

> **SG Mobile 075 находится в тестовой линии.** Публичный APK считается выпущенным только после появления отдельного GitHub Release с APK и контрольной суммой SHA-256. До этого момента не используйте APK из комментариев, случайных зеркал или сторонних сообщений.

| Параметр | Значение |
|---|---|
| Линия приложения | **075** |
| Android | **8.0 и новее** |
| Архитектура | **arm64-v8a** |
| versionCode | **194** |
| versionName | `0.0.94-compact-ping` |
| Интерфейс | Русский, светлая и тёмная темы |
| Исходный код | В этом публичном репозитории не размещается |

---

## О проекте

**SG Mobile** — Android-клиент экосистемы SG для работы как с отдельными VPN-профилями, так и с крупными подписками, содержащими множество серверов и разные протоколы.

Приложение объединяет несколько сетевых движков и даёт единый сценарий работы:

1. импортировать профиль, конфигурацию AWG, QR-код или подписку;
2. проверить и отфильтровать серверы;
3. выбрать маршрутизацию и политику VPN для приложений;
4. подключиться;
5. видеть фактическое состояние соединения, скорость, трафик и диагностические события.

**Без набора отдельных VPN-приложений под каждый протокол.**

---

## Основные возможности

| Область | Возможности |
|---|---|
| **Профили** | Импорт отдельных ссылок, файлов конфигурации и QR-кодов |
| **Подписки** | Обновление, массовый импорт, фильтры, сортировка, проверка и удаление нод |
| **Протоколы** | VLESS, VMess, Trojan, Hysteria2, Mieru, AnyTLS, TUIC, AWG 2.0, AWG 3.0 и AWG 3.1 |
| **Маршрутизация** | VPN, Direct, Block, пользовательские правила, RU White List, RU Blocked и GeoFiles |
| **VPN для приложений** | Весь трафик, только выбранные приложения или исключение выбранных |
| **Мониторинг** | Скорость, трафик сессии, графики и распределение VPN / Direct / Block |
| **Защита** | IPv4, IPv6, DNS policy, Always-on VPN и системный Kill Switch |
| **Стабильность** | Переключение Wi-Fi / LTE / 5G, восстановление соединения и настройка MTU |
| **Резервная копия** | Экспорт, проверка и восстановление пользовательских данных |
| **Диагностика** | Журнал событий, данные подключения и безопасный экспорт отчёта |
| **Справка** | 16 русских разделов, встроенных в приложение и доступных без интернета |

---

## Протоколы и сетевые движки

SG Mobile не маскирует разные технологии под один условный профиль. Для каждого семейства используется соответствующий runtime.

| Профиль или формат | Runtime |
|---|---|
| VLESS, VMess, Trojan | **libXray** |
| Hysteria2 | **Hysteria2 runtime** |
| AnyTLS, TUIC | **sing-box** |
| Mieru | **Mieru / Mihomo** |
| Совместимые proxy-конфигурации | **Mihomo** |
| AWG 2.0 | **AmneziaWG** |
| AWG 3.0 | **AmneziaWG 3.0** |
| AWG 3.1 | **AmneziaWG 3.1** |

Поддержка конкретной ссылки зависит от полноты конфигурации. Обязательные параметры проверяются до запуска подключения.

---

## Профили и подписки

SG Mobile хранит единичные профили отдельно от подписок. Это позволяет одновременно использовать личные конфигурации и управляемые каталоги серверов.

Для подписок доступны:

- обновление источника;
- фильтры по протоколу, стране и доступности;
- сортировка и проверка задержки;
- выбор конкретного сервера без немедленного подключения;
- отдельное удаление ноды;
- импорт смешанных наборов протоколов.

---

## Маршрутизация

Маршрутизация является отдельной частью клиента, а не скрытым параметром профиля.

- **VPN** — направить трафик через активный туннель;
- **Direct** — вывести напрямую;
- **Block** — заблокировать;
- пользовательские правила;
- RU White List и RU Blocked;
- правила на основе GeoFiles;
- отдельная политика для локальной сети.

---

## VPN для приложений и защита от утечек

Для установленных Android-приложений можно выбрать одну из политик:

- весь трафик устройства;
- только выбранные приложения;
- исключить выбранные приложения из VPN.

Отдельный экран защиты контролирует IPv4, IPv6 и DNS policy, а также помогает настроить системные функции Android: **Always-on VPN** и **Block connections without VPN**.

---

## Мониторинг трафика

SG Mobile показывает не только индикатор «Подключено».

Доступны:

- текущая скорость загрузки и отправки;
- объём трафика за сессию;
- накопленная статистика;
- график за последние 15 минут;
- распределение трафика по VPN / Direct / Block;
- локальная диагностика активного соединения.

Payload пользовательского трафика не читается и не сохраняется.

---

## Резервная копия и диагностика

В пользовательскую резервную копию входят профили, подписки, настройки, маршрутизация, Per-App VPN и статистика. Перед восстановлением содержимое можно проверить.

Диагностика содержит журнал событий, состояние активного профиля и данные, необходимые для воспроизведения ошибки. Перед публикацией отчёта его следует очистить от действующих конфигураций, токенов и других секретов.

---

## Интерфейс

Все изображения ниже — исходные PNG **1080 × 2340**. Файлы не уменьшены и не перекодированы. Нажатие открывает полный оригинал.

### Главный экран

<table>
<tr>
<td align="center" width="50%"><b>VPN отключён</b><br><sub>Профиль, состояние и быстрые действия</sub><br><br><a href="docs/screenshots/01-home-disconnected.png"><img src="docs/screenshots/01-home-disconnected.png" alt="Главный экран, VPN отключён" width="330"></a></td>
<td align="center" width="50%"><b>VPN подключён</b><br><sub>Активное соединение, скорость и трафик</sub><br><br><a href="docs/screenshots/02-home-connected.png"><img src="docs/screenshots/02-home-connected.png" alt="Главный экран, VPN подключён" width="330"></a></td>
</tr>
</table>

### Профили и импорт

<table>
<tr>
<td align="center" width="50%"><b>Список профилей</b><br><sub>Протоколы, доступность и задержка</sub><br><br><a href="docs/screenshots/03-profiles.png"><img src="docs/screenshots/03-profiles.png" alt="Список профилей" width="330"></a></td>
<td align="center" width="50%"><b>Импорт</b><br><sub>Ссылка, файл конфигурации или QR-код</sub><br><br><a href="docs/screenshots/04-import-profile.png"><img src="docs/screenshots/04-import-profile.png" alt="Импорт профиля" width="330"></a></td>
</tr>
</table>

### Подписки

<table>
<tr>
<td align="center" width="50%"><b>Список подписок</b><br><sub>Источники, обновление и управление</sub><br><br><a href="docs/screenshots/05-subscriptions.png"><img src="docs/screenshots/05-subscriptions.png" alt="Список подписок" width="330"></a></td>
<td align="center" width="50%"><b>Ноды подписки</b><br><sub>Фильтры, протоколы и доступность серверов</sub><br><br><a href="docs/screenshots/06-subscription-nodes.png"><img src="docs/screenshots/06-subscription-nodes.png" alt="Ноды подписки" width="330"></a></td>
</tr>
</table>

### Трафик и маршрутизация

<table>
<tr>
<td align="center" width="50%"><b>Статистика трафика</b><br><sub>Скорость, объёмы и распределение маршрутов</sub><br><br><a href="docs/screenshots/07-traffic-statistics.png"><img src="docs/screenshots/07-traffic-statistics.png" alt="Статистика трафика" width="330"></a></td>
<td align="center" width="50%"><b>Маршрутизация</b><br><sub>VPN, Direct, Block и пользовательские правила</sub><br><br><a href="docs/screenshots/08-routing.png"><img src="docs/screenshots/08-routing.png" alt="Маршрутизация" width="330"></a></td>
</tr>
</table>

### Управление трафиком приложений

<table>
<tr>
<td align="center" width="50%"><b>VPN для приложений</b><br><sub>Все приложения, выбранные или исключённые</sub><br><br><a href="docs/screenshots/09-per-app.png"><img src="docs/screenshots/09-per-app.png" alt="VPN для приложений" width="330"></a></td>
<td align="center" width="50%"><b>Защита от утечек</b><br><sub>IPv4, IPv6, DNS и системная VPN policy</sub><br><br><a href="docs/screenshots/10-leak-protection.png"><img src="docs/screenshots/10-leak-protection.png" alt="Защита от утечек" width="330"></a></td>
</tr>
</table>

### Обслуживание

<table>
<tr>
<td align="center" width="50%"><b>Резервная копия</b><br><sub>Экспорт, проверка и восстановление</sub><br><br><a href="docs/screenshots/11-backup.png"><img src="docs/screenshots/11-backup.png" alt="Резервная копия" width="330"></a></td>
<td align="center" width="50%"><b>Диагностика</b><br><sub>Журнал событий и данные подключения</sub><br><br><a href="docs/screenshots/12-diagnostics.png"><img src="docs/screenshots/12-diagnostics.png" alt="Диагностика" width="330"></a></td>
</tr>
</table>

Полный набор из 14 исходных снимков, включая график за 15 минут и настройки автоповорота/батареи, находится в [каталоге скриншотов](docs/screenshots/README.md).

---

## Быстрый старт

1. Откройте раздел [Releases](../../releases).
2. Скачайте APK и файл контрольных сумм из одного релиза.
3. Сравните SHA-256 скачанного APK с опубликованным значением.
4. Установите APK на Android 8.0 или новее.
5. Добавьте профиль, AWG-конфигурацию или адрес подписки.
6. Разрешите Android создать VPN-подключение.
7. После подключения проверьте состояние и статистику трафика.

---

## Проверка APK

Windows PowerShell:

```powershell
Get-FileHash .\SG-Mobile.apk -Algorithm SHA256
```

Linux:

```bash
sha256sum SG-Mobile.apk
```

macOS:

```bash
shasum -a 256 SG-Mobile.apk
```

Совпасть должна вся строка SHA-256.

---

## Документация

- [Полная русская справка](HELP-RU.md)
- [Частые вопросы](FAQ.md)
- [Поддержка и сообщения об ошибках](SUPPORT.md)
- [История изменений](CHANGELOG.md)
- [Правила безопасной публикации отчётов](SECURITY.md)
- [Уведомления о сторонних компонентах](THIRD-PARTY-NOTICES.md)
- [Полная галерея интерфейса](docs/screenshots/README.md)
- [Состав публичного релиза](docs/releases/README.md)

В приложении пункт **«Справка»** находится в боковом меню между **«Диагностика»** и **«О приложении»**.

---

## Сообщение об ошибке

Перед отчётом подготовьте модель телефона, версию Android и оболочки, версию SG Mobile, используемый протокол, тип сети, точные шаги воспроизведения и время возникновения ошибки.

Не публикуйте конфигурацию, резервную копию или журнал без предварительной проверки. Подробный порядок находится в [SUPPORT.md](SUPPORT.md), а правила очистки данных — в [SECURITY.md](SECURITY.md).

---

## Лицензии и сторонние компоненты

SG Mobile использует сторонние сетевые движки и библиотеки с собственными лицензиями. Перечень компонентов и зафиксированные версии приведены в [THIRD-PARTY-NOTICES.md](THIRD-PARTY-NOTICES.md).

Условия распространения самого SG Mobile будут опубликованы отдельно. Отсутствие файла LICENSE в этом репозитории не означает передачу прав на приложение или его материалы.

---

<div align="center">

**SG Mobile 075**

Android · Xray · sing-box · Hysteria2 · Mieru · Mihomo · AmneziaWG

</div>
