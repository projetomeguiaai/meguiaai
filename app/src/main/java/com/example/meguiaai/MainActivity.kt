package com.example.meguiaai

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.meguiaai.fragments.RecognitionFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomMenu: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setCurrentFragment(RecognitionFragment())

        bottomMenu = findViewById(R.id.bottom_navigation)
        bottomMenu.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.recognition -> {
                    setCurrentFragment(RecognitionFragment())
                }
                R.id.downloads -> {
                    setCurrentFragment(RecognitionFragment())
                }
                R.id.training -> {
                    setCurrentFragment(RecognitionFragment())
                }
            }
            return@setOnItemSelectedListener true
        }
    }
    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, fragment)
            .commit()
    }
}