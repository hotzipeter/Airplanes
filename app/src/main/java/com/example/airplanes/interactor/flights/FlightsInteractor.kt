package com.example.airplanes.interactor.flights

import android.util.Log
import com.example.airplanes.interactor.flights.event.GetFlightsEvent
import com.example.airplanes.network.FlightsApi
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class FlightsInteractor @Inject constructor(private var flightsApi: FlightsApi){
    fun getFlights( direction: String,route: String?){
        val event = GetFlightsEvent()
        val auth =
            "Accept: application/json\napp_id: 450c8aad\napp_key: f01458acfa0d58ca81d80777a7ceb46e\nResourceVersion: v4"
        try {
            val response = flightsApi.getFlights(auth, direction, route).execute()
            Log.d("Reponse", response.body().toString())
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
            event.code = response.code()
            event.flights = response.body()?.flights
            EventBus.getDefault().post(event)
        }catch (e: Exception){
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }
}