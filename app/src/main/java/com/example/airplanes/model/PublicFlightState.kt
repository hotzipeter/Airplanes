package com.example.airplanes.model

import com.google.gson.annotations.SerializedName

class PublicFlightState {
    @SerializedName("flightStates")
    var flightStates: List<String>? = null
}