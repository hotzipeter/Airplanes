package com.example.airplanes.model

import com.google.gson.annotations.SerializedName

class CheckinClass {
    @SerializedName("code")
    var code: String? = null
    @SerializedName("descripotion")
    var description: String? = null
}