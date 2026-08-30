# WiFi Hotspot Fixer — buat kasus iPhone susah connect hotspot 5GHz

App Android open-source (bikinan khusus, gratis tanpa iklan) yang ngejalanin perintah
`cmd wifi` (shell privilege) lewat **Wireless Debugging** — tanpa PC, tanpa root.

## Kenapa app ini ada
Hotspot 5GHz Android kadang milih channel DFS/otomatis yang bikin iPhone gagal connect.
Solusinya: paksa region + lock channel non-DFS (ch 48) via command `cmd wifi`.
UI Android gak punya setting itu, app biasa gak punya izin — satu-satunya pintu = shell command.

## Isi project
- `.github/workflows/build.yml` — build APK otomatis di GitHub Actions (hasil: artifact APK)
- `app/` — source code Kotlin (MainActivity + ADB client lokal)
- Cara pakai app: aktifin Developer Options → Wireless Debugging → pairing → tombol FIX

## Syarat pakai
- HP hotspot Android 11+ (fitur Wireless Debugging)
- ADB command butuh shell permission (dapat dari wireless debugging sendiri)
- Command ilang setelah reboot → tinggal tekan tombol Fix lagi
