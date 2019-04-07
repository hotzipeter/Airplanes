package com.example.airplanes.ui.details

import com.example.airplanes.model.Flight

interface DetailsScreen {
    fun showFlightDetail(flight: Flight)
    fun changeButtonImg()
    fun showNetworkError(errorMsg: String)
}