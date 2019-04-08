package com.example.airplanes

import android.app.Activity
import android.support.v4.app.Fragment



val Activity.injector: AirplanesApplicationComponent
    get() {
        return (this.applicationContext as AirplanesApplication).injector
    }

val Fragment.injector: AirplanesApplicationComponent
    get() {
        return (this.context!!.applicationContext as AirplanesApplication).injector
    }

