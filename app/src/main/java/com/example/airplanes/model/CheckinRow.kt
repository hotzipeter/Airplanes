package com.example.airplanes.model


import com.example.airplanes.model.Remarks
import com.google.gson.annotations.SerializedName

class CheckinRow {
    @SerializedName("position")
    var position: String? = null
    @SerializedName("desks")
    var desks: Desks? = null
}