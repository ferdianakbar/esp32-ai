# WiFi Hotspot Fixer 🔶

App Android **gratis tanpa iklan** buat fix iPhone susah connect ke hotspot 5GHz Android.

## Cara pakai (sekali setup, ±5 menit)
1. Di HP hotspot: **Settings → About phone → tap Build number 7×** (buka Developer Options)
2. **Developer Options → Wireless Debugging → ON** → tap "Pair device with pairing code"
3. Di app ini: isi **IP:port & pairing code** dari langkah 2 → tekan PAIR
4. Setelah paired → tekan tombol FIX ✅

## Tombol
| Tombol | Command yang dijalankan | Fungsi |
|---|---|---|
| 🔧 FIX | `cmd wifi force-country-code enabled ID` | Paksa region Indonesia — hotspot gak milih channel DFS lagi |
| 📡 LOCK CH48 | `cmd wifi force-softap-channel enabled 5240` | Kunci hotspot 5GHz ke channel 48 (non-DFS) |
| 📊 Status | `cmd wifi status` | Lihat status WiFi/hotspot |

⚠️ Efek hilang setelah reboot → tekan FIX lagi (atau bikin module Magisk kalau rooted).

## Build
GitHub Actions otomatis: push repo → artifact `.apk` siap install.
