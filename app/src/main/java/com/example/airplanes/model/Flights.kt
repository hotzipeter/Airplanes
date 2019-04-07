package com.example.airplanes.model

import com.google.gson.annotations.SerializedName

class Flights {
    @SerializedName("flights")
    var flights: List<Flights>? = null
}