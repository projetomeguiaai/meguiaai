package com.example.meguiaai

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bottomMenu = findViewById(R.id.bottom_navigation)
        bottomMenu.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.recognition -> {
                    Toast.makeText(this, "Camera", Toast.LENGTH_SHORT).show()
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
}