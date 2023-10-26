package com.example.meguiaai

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.meguiaai.databinding.ActivityMainBinding
import com.example.meguiaai.fragments.AssetsFragment
import com.example.meguiaai.fragments.CameraFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        setCurrentFragment(CameraFragment())

        var bottomMenu: BottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomMenu.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.home_item -> {
                    setCurrentFragment(CameraFragment())
                }
                R.id.assets_item -> {
                    setCurrentFragment(AssetsFragment())
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

    override fun onBackPressed() {
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.Q) {
            finishAfterTransition()
        } else {
            super.onBackPressed()
        }
    }
}
