package project.uas.ppb.detail

import android.os.Bundle
import android.widget.VideoView
import android.net.Uri
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import project.uas.ppb.R

class ProfilProdi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profil_prodi)

        // Mengatur padding untuk status bar dan navigation bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Menyiapkan VideoView
        val videoView = findViewById<VideoView>(R.id.videoView2)

        // Menyiapkan URI untuk video di folder raw
        val videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.prodimesin)

        // Memasukkan URI ke VideoView
        videoView.setVideoURI(videoUri)

        // Menyediakan listener agar video mulai diputar ketika siap
        videoView.setOnPreparedListener {
            videoView.start()  // Mulai memutar video
        }

        // Tombol Back Listener
        val backButton = findViewById<ImageView>(R.id.back_button)
        backButton.setOnClickListener {
            // Menampilkan Toast
            Toast.makeText(this, "Berhasil Kembali", Toast.LENGTH_SHORT).show()

            // Menutup Activity dan kembali ke fragment sebelumnya
            finish()
        }
    }
}
