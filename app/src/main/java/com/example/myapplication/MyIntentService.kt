package com.example.myapplication

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.util.Log

class BackgroundService : IntentService("BackgroundService") {

    override fun onHandleIntent(intent: Intent?) {
        try {
            val dataString = intent!!.dataString
            Thread.sleep(5000)
            Log.d("BackgroundService", "je suis passé ici")
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Backgroundservice", "onDestroy")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("BackgroundService", "onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onCreate() {
        Log.d("BackgroundService", "onCreate")
        super.onCreate()
    }


}
