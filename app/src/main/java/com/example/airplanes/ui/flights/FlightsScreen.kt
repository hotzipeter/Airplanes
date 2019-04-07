package com.example.airplanes.ui.flights

import com.example.airplanes.model.Flight

interface FlightsScreen {
    fun showFlights(flights: List<Flight>)
}