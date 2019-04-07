package com.example.airplanes.model

import com.google.gson.annotations.SerializedName

class Allocations {
    @SerializedName("endTime")
    var endTime: String? = null
    @SerializedName("rows")
    var remarks: Rows? = null
    @SerializedName("startTime")
    var startTime: String? = null
}