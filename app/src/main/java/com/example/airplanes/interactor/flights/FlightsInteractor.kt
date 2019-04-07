package com.example.airplanes.interactor.flights

import com.example.airplanes.network.FlightsApi
import javax.inject.Inject

class FlightsInteractor @Inject constructor(private var flightsApi: FlightsApi){
    fun getFlights( direction: String,
                   fromDate: String,
                   toDate: String,
                   route: String){}
}