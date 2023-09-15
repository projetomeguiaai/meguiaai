package com.example.meguiaai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomMenu: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomMenu = findViewById(R.id.bottom_navigation)
        bottomMenu.setOnItemReselectedListener { item ->
            when(item.itemId) {
                R.id.camera -> {}
                R.id.models -> {}
                R.id.training -> {}
            }
        }
    }
}