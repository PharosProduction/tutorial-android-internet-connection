package com.pharosproduction.internet_connection

import android.app.Application
import android.content.IntentFilter
import android.os.Build

class App : Application() {

    // Life

    override fun onCreate() {
        super.onCreate()
        registerConnectionReceiver()
    }

    // Private

    private fun registerConnectionReceiver() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            val receiver = Receiver()
            val intentFilter = IntentFilter()
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE")
            registerReceiver(receiver, intentFilter)
        }
    }
}