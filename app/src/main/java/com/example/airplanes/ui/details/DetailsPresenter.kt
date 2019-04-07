package com.example.airplanes.ui.details

import com.example.airplanes.model.Flight
import com.example.airplanes.ui.Presenter

class DetailsPresenter : Presenter<DetailsScreen>() {

    fun showFlightDetails(flight: Flight){
        screen?.showFlightDetail(flight)
    }
}