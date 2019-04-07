package com.example.airplanes.model

import com.google.gson.annotations.SerializedName

class AircraftType {
    @SerializedName("iataMain")
    var iataMain: String? = null
    @SerializedName("iataSub")
    var iataSub: String? = null
}