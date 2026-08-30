package id.ferdian.wifihotspotfixer

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    private val executor = Executors.newSingleThreadExecutor()
    private lateinit var status: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        status = findViewById(R.id.status)

        findViewById<Button>(R.id.btnFix).setOnClickListener {
            runFix("cmd wifi force-country-code enabled ID")
        }
        findViewById<Button>(R.id.btnChannel).setOnClickListener {
            runFix("cmd wifi force-softap-channel enabled 5240")
        }
        findViewById<Button>(R.id.btnStatus).setOnClickListener {
            runFix("cmd wifi status")
        }
    }

    private fun runFix(command: String) {
        status.text = "Menjalankan: $command …"
        executor.execute {
            val out = execShell(command)
            runOnUiThread { status.text = ">>> $command\n\n$out" }
        }
    }

    private fun execShell(cmd: String): String {
        return try {
            val p = Runtime.getRuntime().exec(arrayOf("sh", "-c", cmd))
            val std = BufferedReader(InputStreamReader(p.inputStream)).readText()
            val err = BufferedReader(InputStreamReader(p.errorStream)).readText()
            p.waitFor()
            (std + "\n" + err).trim()
        } catch (e: Exception) {
            "GAGAL: ${e.message}\n\nApp tanpa privilege shell? Aktifkan Wireless Debugging dulu."
        }
    }
}
