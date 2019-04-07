package com.example.airplanes.model

import com.google.gson.annotations.SerializedName

class Rows {
    @SerializedName("rows")
    var row: List<CheckinRow>? = null
}