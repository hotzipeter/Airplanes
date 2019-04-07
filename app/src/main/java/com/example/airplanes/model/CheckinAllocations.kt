package com.example.airplanes.model

import com.google.gson.annotations.SerializedName

class CheckinAllocations {

    @SerializedName("checkinAllocations")
    var checkinAllocations: List<Allocations>? = null
    @SerializedName("remarks")
    var remarks: Remarks? = null
}