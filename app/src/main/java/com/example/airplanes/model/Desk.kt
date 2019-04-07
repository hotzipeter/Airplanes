package com.example.airplanes.model

import com.google.gson.annotations.SerializedName

class Desk {
    @SerializedName("checkinClass")
    var checkinClass: CheckinClass? = null
    @SerializedName("position")
    var position: Int? = null
}