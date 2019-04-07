package com.example.airplanes.model

import com.google.gson.annotations.SerializedName

class FlightRoute {
    @SerializedName("destinations")
    var destinations: List<String>? = null
    @SerializedName("eu")
    var eu: String? = null
    @SerializedName("visa")
    var visa: Boolean? = null
}