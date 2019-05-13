package com.example.airplanes.interactor.flights


import android.util.Log

import com.example.airplanes.interactor.flights.event.GetFlightsEvent
import com.example.airplanes.model.Flight
import com.example.airplanes.model.Flights
import com.example.airplanes.network.FlightsApi
import com.example.airplanes.network.FlightsPageApi
import org.greenrobot.eventbus.EventBus
import retrofit2.Response
import java.text.SimpleDateFormat

import java.time.LocalDateTime
import java.util.*

import javax.inject.Inject

class FlightsInteractor @Inject constructor(private var flightsApi: FlightsApi, private var flightsPageApi: FlightsPageApi){

    fun getFlights(direction: String, route: String?){
        val event = GetFlightsEvent()
        var auth: Map<String, String> = hashMapOf("Accept" to "application/json", "app_id" to "450c8aad", "app_key" to "f01458acfa0d58ca81d80777a7ceb46e","ResourceVersion" to "v4")

        try {
            var time=Calendar.getInstance()

            val sdf = SimpleDateFormat("yyyy-MM-dd kk:mm:ss")
            val stringTime=sdf.format(time.time).replace(' ','T')
            time.add(Calendar.DAY_OF_MONTH,1)
            val stringTime1=sdf.format(time.time).replace(' ','T')
            var response : Response<Flights>
            var response1 : Response<Flights>
            var response2 : Response<Flights>
            var response3 : Response<Flights>
            var flights: List<Flight>?
            var flights1: List<Flight>?
            var flights2: List<Flight>?
            var flights3: List<Flight>?
            if (route=="") {
                response = flightsApi.getFlights(auth, direction, stringTime, stringTime1,"scheduleDateTime").execute()
                flights = response.body()?.flights
                response1 =
                    flightsPageApi.getFlightsWithPages(auth, direction, stringTime, stringTime1, "scheduleDateTime", 1).execute()
                flights1 = response1.body()?.flights?.let { flights?.plus(it) }
                response2 =
                    flightsPageApi.getFlightsWithPages(auth, direction, stringTime, stringTime1,"scheduleDateTime", 2).execute()
                flights2 = response2.body()?.flights?.let { flights1?.plus(it) }
                response3 =
                    flightsPageApi.getFlightsWithPages(auth, direction, stringTime, stringTime1,"scheduleDateTime", 3).execute()
                flights3 = response3.body()?.flights?.let { flights2?.plus(it) }
            }else{
                response = flightsApi.getFlightsWithDirection(auth, direction,route, stringTime,stringTime1, "scheduleDateTime").execute()
                flights = response.body()?.flights
                response1 =
                    flightsPageApi.getFlightsWithRouteAndPages(auth, direction,route, stringTime, stringTime1, "scheduleDateTime", 1).execute()
                flights1 = response1.body()?.flights?.let { flights?.plus(it) }
                response2 =
                    flightsPageApi.getFlightsWithRouteAndPages(auth, direction,route, stringTime, stringTime1,"scheduleDateTime", 2).execute()
                flights2 = response2.body()?.flights?.let { flights1?.plus(it) }
                response3 =
                    flightsPageApi.getFlightsWithRouteAndPages(auth, direction,route, stringTime, stringTime1,"scheduleDateTime", 3).execute()
                flights3 = response3.body()?.flights?.let { flights2?.plus(it) }
            }

            if (response.code() != 200) {

                throw Exception(response.code().toString())
            }
            event.code = response.code()
            event.flights =flights3
            EventBus.getDefault().post(event)
        }catch (e: Exception){
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }
}