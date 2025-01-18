package project.uas.ppb.detail

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import project.uas.ppb.R

class DosenstafActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Untuk mendukung edge-to-edge display
        setContentView(R.layout.activity_dosenstaf)

        // Tombol Back Listener
        val backButton = findViewById<ImageView>(R.id.imageView18)
        backButton.setOnClickListener {
            finish() // Menutup Activity dan kembali ke fragment sebelumnya
        }
    }
}
