<div align="center">

# SG Mobile 077

### Универсальный VPN-клиент для Android

**SMART Failover, профили и подписки, маршрутизация, Per-App VPN, DNS policy, мониторинг и защита от утечек — в одном интерфейсе.**

<p>
  <img alt="Release line" src="https://img.shields.io/badge/Release%20line-077-2563EB?style=for-the-badge">
  <img alt="Status" src="https://img.shields.io/badge/Status-Testing-F59E0B?style=for-the-badge">
  <img alt="Android" src="https://img.shields.io/badge/Android-8.0%2B-3DDC84?style=for-the-badge&logo=android&logoColor=white">
  <img alt="ABI" src="https://img.shields.io/badge/ABI-arm64--v8a-5865F2?style=for-the-badge">
</p>

<p>
  <img alt="SMART" src="https://img.shields.io/badge/SMART-Failover-16A34A?style=flat-square">
  <img alt="Xray" src="https://img.shields.io/badge/Xray-libXray-2563EB?style=flat-square">
  <img alt="sing-box" src="https://img.shields.io/badge/sing--box-AnyTLS%20%7C%20TUIC-0EA5E9?style=flat-square">
  <img alt="Hysteria2" src="https://img.shields.io/badge/Hysteria2-supported-8B5CF6?style=flat-square">
  <img alt="Mieru" src="https://img.shields.io/badge/Mieru-supported-7C3AED?style=flat-square">
  <img alt="AmneziaWG" src="https://img.shields.io/badge/AmneziaWG-AWG%202.0%20%7C%203.0%20%7C%203.1-6D5BD0?style=flat-square">
</p>

<p>
  <a href="docs/releases/077.md"><img alt="077" src="https://img.shields.io/badge/077-ЧТО%20НОВОГО-2563EB?style=for-the-badge"></a>
  <a href="../../releases"><img alt="Releases" src="https://img.shields.io/badge/RELEASES-ОТКРЫТЬ-2F6B57?style=for-the-badge"></a>
  <a href="HELP-RU.md"><img alt="Русская справка" src="https://img.shields.io/badge/СПРАВКА-РУССКАЯ-0EA5E9?style=for-the-badge"></a>
  <a href="../../issues"><img alt="Сообщить об ошибке" src="https://img.shields.io/badge/ISSUES-СООБЩИТЬ-6B7280?style=for-the-badge"></a>
</p>

</div>

---

## Текущий статус

> **SG Mobile 077 находится в тестовой линии.** Публичный APK считается выпущенным только после появления отдельного GitHub Release с APK и контрольной суммой SHA-256.

| Параметр | Значение |
|---|---|
| Линия приложения | **077** |
| Android | **8.0 и новее** |
| Архитектура | **arm64-v8a** |
| versionCode | **196** |
| versionName | `0.0.96-smart-failover` |
| Интерфейс | Русский, светлая и тёмная темы |
| Исходный код | В этом публичном репозитории не размещается |

> **Важно:** NaiveProxy в линию 077 не входит.

---

## Главное в 077

### SMART Failover

Можно задать основной VPN-профиль и до трёх резервных приоритетов. Если текущее соединение перестаёт работать, SG Mobile проверяет доступные варианты и автоматически переключается на рабочий.

Одновременно активен только один VPN-профиль: SMART — это failover, а не параллельное распределение трафика между несколькими ядрами.

SMART поддерживает:

- готовые сценарии для домашней, мобильной и нестабильной сети;
- cooldown отказавших профилей;
- ограничение количества переключений;
- запоминание последнего рабочего профиля;
- автоматический возврат на основной профиль;
- выбор резерва по профилю, протоколу, избранному, подписке или любому доступному узлу.

### Проверка реального соединения

SG Mobile различает «ядро запущено» и «VPN действительно работает». Для контроля используются runtime-state, DNS/HTTPS-проверки и дополнительные признаки доступности сети.

Во время автоматического переключения используется blocking TUN, чтобы трафик не уходил мимо VPN.

### Routing и Ads

Маршрутизация включает:

- VPN / Direct / Block;
- пользовательские правила;
- RU White List;
- RU Blocked;
- GeoFiles;
- отдельную политику для локальной сети;
- блокировку рекламы и трекеров.

Для AmneziaWG добавлен routed-путь через локальный SOCKS bridge и Xray routing, поэтому правила Routing и Ads можно применять и к AWG-профилям.

### Единая DNS policy

В 077 используется единая DNS-политика для разных runtime.

Доступны SG Auto, Cloudflare, Google, AdGuard, Quad9, System DNS, собственный IPv4/IPv6 DNS и Custom DoH.

### Per-App VPN

Можно направлять через VPN весь трафик устройства, только выбранные приложения либо исключать выбранные приложения из VPN.

---

## Поддерживаемые протоколы

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

**NaiveProxy не входит в SG Mobile 077.**

---

## Профили и подписки

SG Mobile работает как с отдельными профилями, так и с подписками, содержащими много серверов и разные протоколы.

Для подписок доступны обновление источника, фильтры, сортировка, проверка задержки, выбор конкретной ноды и удаление отдельных нод.

---

## Стабильность

Сохранены и развиты механизмы восстановления соединения:

- reconnect после проблем с сетью;
- корректная работа при переключении Wi‑Fi / LTE / 5G;
- защита от параллельных connect/disconnect;
- Quick Settings Tile;
- управление соединением из уведомления;
- отображение реально активного VPN-профиля;
- защита от stale-профилей подписки;
- ручной и автоматический MTU.

---

## Мониторинг и диагностика

SG Mobile показывает текущую скорость, трафик сессии, накопленную статистику, графики и распределение VPN / Direct / Block.

Диагностика содержит журнал событий и технические данные активного соединения. Перед публикацией отчётов необходимо удалять действующие конфигурации, токены и другие секреты.

---

## Что изменилось относительно 075

**075** — ручной VPN-клиент с быстрым ping, мониторингом трафика и выбором сервера.

**077** — более автономный VPN-клиент с SMART Failover, unified DNS, Per-App VPN, routed AmneziaWG, расширенной маршрутизацией и более строгим контролем реальной работоспособности соединения.

Полное описание изменений: **[SG Mobile 077 — SMART Failover](docs/releases/077.md)**.

---

## Публикация APK

APK следует скачивать только из раздела **GitHub Releases** этого репозитория.

Для каждой опубликованной сборки проверяйте:

- `versionCode` и `versionName` внутри APK;
- SHA-256 APK;
- подпись приложения;
- соответствие архитектуры `arm64-v8a`.

Не используйте APK из случайных зеркал и сторонних сообщений.
