package com.example.meguiaai

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.media.Image
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Display
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.camera.view.PreviewView
import androidx.core.content.res.ResourcesCompat
import com.example.meguiaai.services.ClassificationService
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.task.core.BaseOptions
import org.tensorflow.lite.task.vision.classifier.Classifications
import org.tensorflow.lite.task.vision.classifier.ImageClassifier
import org.tensorflow.lite.task.vision.classifier.ImageClassifier.ImageClassifierOptions
import java.io.File
import java.lang.IllegalStateException

class MainActivity : AppCompatActivity() {
    private lateinit var bottomMenu: BottomNavigationView
    private var classificationService = ClassificationService(this, "model_file.tflite", View, getDeviceDisplay())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bottomMenu = findViewById(R.id.bottom_navigation)
        bottomMenu.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.recognition -> {

                }
                R.id.downloads -> {
                    Toast.makeText(this, "Downloads", Toast.LENGTH_SHORT).show()
                }
                R.id.training -> {
                    Toast.makeText(this, "Training", Toast.LENGTH_SHORT).show()
                }
            }
            return@setOnItemSelectedListener true
        }
    }
    @Suppress("DEPRECATION")
    private fun getDeviceDisplay(): Display? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            this.display
        } else {
            this.windowManager.defaultDisplay
        }
    }
}