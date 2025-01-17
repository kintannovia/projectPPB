package project.uas.ppb

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Referensi elemen UI
        val animatedText: TextView = findViewById(R.id.animatedText)
        val animatedImage: ImageView = findViewById(R.id.animatedImage)
        val zoomImage: ImageView = findViewById(R.id.imageView4)

        // Teks untuk animasi
        val textToAnimate = "TEKNIK MESIN"
        var currentText = ""
        var index = 0

        // Daftar gambar untuk animasi bergantian
        val images = listOf(
            R.drawable.fts,
            R.drawable.uikalogo,
            R.drawable.splashlogo
        )

        // Handler untuk animasi teks
        val handler = Handler(Looper.getMainLooper())
        val textAnimationRunnable = object : Runnable {
            override fun run() {
                if (index < textToAnimate.length) {
                    currentText += textToAnimate[index]
                    animatedText.text = currentText
                    index++
                    handler.postDelayed(this, 100)
                } else {
                    animatedImage.visibility = View.VISIBLE
                    showImagesWithFadeIn(animatedImage, images)
                    handler.postDelayed({
                        fadeOutElementsAndZoom(zoomImage, listOf(animatedText, animatedImage))
                    }, 3000)
                }
            }
        }

        handler.post(textAnimationRunnable)
    }

    // Fungsi untuk animasi gambar dengan fade-in
    private fun showImagesWithFadeIn(imageView: ImageView, images: List<Int>) {
        val handler = Handler(Looper.getMainLooper())
        val fadeDuration = 1000L
        val delayBetweenImages = 1000L
        var imageIndex = 0

        val imageAnimationRunnable = object : Runnable {
            override fun run() {
                if (imageIndex < images.size) {
                    imageView.setImageResource(images[imageIndex])
                    val fadeIn = ObjectAnimator.ofFloat(imageView, "alpha", 0f, 1f)
                    fadeIn.duration = fadeDuration
                    fadeIn.start()
                    imageIndex++
                    handler.postDelayed(this, delayBetweenImages)
                }
            }
        }
        handler.post(imageAnimationRunnable)
    }

    // Fungsi untuk fade-out elemen dan zoom gambar
    private fun fadeOutElementsAndZoom(zoomImage: ImageView, elementsToFadeOut: List<View>) {
        // Animasi fade-out elemen lainnya
        elementsToFadeOut.forEach { element ->
            val fadeOut = ObjectAnimator.ofFloat(element, "alpha", 1f, 0f)
            fadeOut.duration = 500L
            fadeOut.start()
        }

        // Zoom gambar dengan efek memudar ke putih
        val scaleX = ObjectAnimator.ofFloat(zoomImage, "scaleX", 1f, 10f)
        val scaleY = ObjectAnimator.ofFloat(zoomImage, "scaleY", 1f, 10f)
        val fadeOutZoom = ObjectAnimator.ofFloat(zoomImage, "alpha", 1f, 0f)

        scaleX.duration = 1000L
        scaleY.duration = 1000L
        fadeOutZoom.duration = 1000L

        scaleX.interpolator = AccelerateDecelerateInterpolator()
        scaleY.interpolator = AccelerateDecelerateInterpolator()

        scaleX.start()
        scaleY.start()
        fadeOutZoom.start()

        fadeOutZoom.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {}

            override fun onAnimationEnd(animation: Animator) {
                // Buka MainActivity setelah animasi selesai
                startActivity(Intent(this@Splash, MainActivity::class.java))
                finish()
            }

            override fun onAnimationCancel(animation: Animator) {}

            override fun onAnimationRepeat(animation: Animator) {}
        })
    }
}
