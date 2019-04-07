package com.example.airplanes.model

import com.google.gson.annotations.SerializedName

class BaggageClaim {
    @SerializedName("belts")
    var belts: List<String>? = null
}