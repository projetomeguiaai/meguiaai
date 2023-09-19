package com.example.meguiaai.helpers

import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import android.view.Surface
import org.tensorflow.lite.gpu.CompatibilityList
import org.tensorflow.lite.support.image.ImageProcessor
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.task.core.BaseOptions
import org.tensorflow.lite.task.core.vision.ImageProcessingOptions
import org.tensorflow.lite.task.vision.classifier.Classifications
import org.tensorflow.lite.task.vision.classifier.ImageClassifier
import org.tensorflow.lite.task.vision.classifier.ImageClassifier.ImageClassifierOptions
import java.lang.IllegalStateException

class ClassificationHelper(private var context: Context, private var modelPath: String) {
    private var imageClassifier: ImageClassifier? = null

    private fun buildImageClassifier() {
        try {
            imageClassifier = ImageClassifier.createFromFileAndOptions(context, modelPath, makeClassifierOptions())
        } catch (e: IllegalStateException) {
            Log.e(TAG, "Não foi possível abrir o classificador")
            e.printStackTrace()
        }
    }

    fun classifyImage(image: Bitmap, rotation: Int): List<Classifications>? {
        if (imageClassifier == null) buildImageClassifier()

        val tensorImage = ImageProcessor.Builder().build()
            .process(TensorImage.fromBitmap(image))

        val options = ImageProcessingOptions.builder()
            .setOrientation(getOrientationFromRotation(rotation))
            .build()

        return imageClassifier?.classify(tensorImage, options)
    }

    private fun getOrientationFromRotation(rotation: Int): ImageProcessingOptions.Orientation {
        return when (rotation) {
            Surface.ROTATION_0 -> ImageProcessingOptions.Orientation.RIGHT_TOP
            Surface.ROTATION_90 -> ImageProcessingOptions.Orientation.TOP_LEFT
            Surface.ROTATION_180 -> ImageProcessingOptions.Orientation.RIGHT_BOTTOM
            else -> ImageProcessingOptions.Orientation.BOTTOM_RIGHT
        }
    }

    private fun makeClassifierOptions(): ImageClassifierOptions {
        return ImageClassifierOptions.builder()
            .setBaseOptions(getDeviceBaseOptions())
            .setMaxResults(1)
            .setScoreThreshold(.35f)
            .build()
    }
    private fun getDeviceBaseOptions(): BaseOptions {
        return if (CompatibilityList().isDelegateSupportedOnThisDevice) {
            BaseOptions.builder().setNumThreads(1).useGpu().build()
        } else {
            BaseOptions.builder().setNumThreads(2).build()
        }
    }

    companion object {
        private const val TAG = "ClassificationHelper"
    }
}