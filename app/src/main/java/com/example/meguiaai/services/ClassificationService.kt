package com.example.meguiaai.services

import android.content.Context
import android.util.Log
import android.view.Display
import androidx.camera.view.PreviewView
import com.example.meguiaai.helpers.CameraHelper
import com.example.meguiaai.helpers.ClassificationHelper

class ClassificationService(
    context: Context,
    modelPath: String,
    previewView: PreviewView,
    var display: Display?
) {
    val classificationHelper = ClassificationHelper(context, modelPath)
    val cameraHelper = CameraHelper(context, previewView, display)

    fun run() {
        Log.i("msg", cameraHelper.getRotation().toString())
    }
}