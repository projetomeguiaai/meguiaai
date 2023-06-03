package com.example.meguiaai

import android.speech.tts.TextToSpeech
import android.util.Log
import android.app.Activity

class TextToSpeek(private val activity: Activity,
                  private val message: String) : TextToSpeech.OnInitListener {

    private val tts: TextToSpeech = TextToSpeech(activity, this)

    override fun onInit(i: Int) {
        if (i == TextToSpeech.SUCCESS) {
            Log.i("msg", "Sucesso!")
            speakOut(message)
        } else {
            Log.i("msg", "Erro!")
        }

    }

    private fun speakOut(message: String) {
        tts.speak(message, TextToSpeech.QUEUE_FLUSH, null, "")
    }
}