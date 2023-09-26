package com.example.meguiaai.fragments

import android.os.Build
import android.os.Bundle
import android.view.Display
import androidx.camera.view.PreviewView
import androidx.fragment.app.Fragment
import com.example.meguiaai.R
import com.example.meguiaai.helpers.CameraHelper

class RecognitionFragment : Fragment() {
    private lateinit var cameraHelper: CameraHelper
    private var previewView: PreviewView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        previewView = activity?.findViewById(R.id.recognition_preview_view)
        cameraHelper = CameraHelper(requireContext(), previewView, getDeviceDisplay())
    }

    @Suppress("DEPRECATION")
    private fun getDeviceDisplay(): Display? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            requireActivity().display
        } else {
           requireActivity().windowManager.defaultDisplay
        }
    }
}