package com.example.airplanes.ui.details

import android.content.Intent


interface DetailsScreen {
    fun showFlightDetail(intent: Intent)
    fun changeButtonImg(state: Int)
    fun showNetworkError(errorMsg: String)
}