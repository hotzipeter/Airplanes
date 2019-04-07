package com.example.airplanes.interactor.flights.event

import com.example.airplanes.model.Flight

data class GetFlightsEvent (
    var code: Int = 0,
    var flights: List<Flight>? = null,
    var throwable: Throwable? = null
)