package com.example.airplanes

import android.app.Application
import com.example.airplanes.ui.UIModule

class AirplanesApplication : Application() {
    lateinit var injector: AirplanesApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerAirplanesApplicationComponent.builder().uIModule(UIModule(this)).build()
    }
}