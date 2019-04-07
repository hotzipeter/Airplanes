package com.example.airplanes

import android.app.Application
import com.example.airplanes.ui.UIModule

class Airlines : Application() {
    lateinit var injector: AirplanesComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerAirlinesComponent.builder().uIModule(UIModule(this)).build()
    }
}