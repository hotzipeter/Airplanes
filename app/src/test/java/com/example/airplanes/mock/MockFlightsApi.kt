package com.example.airplanes.mock

import com.example.airplanes.model.*
import com.example.airplanes.network.FlightsApi
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class MockFlightsApi : FlightsApi {
    override fun getFlights(authorisation: String, direction: String, route: String?): Call<Flights> {
        val flights= Flights()
        val flight=Flight()
        flight.actualLandingTime=null
        flight.lastUpdatedAt="2019-05-06T00:15:02.195+02:00"
        flight.actualOffBlockTime="2019-05-05T23:53:00.000+02:00"
        flight.aircraftRegistration="TCMCD"
        val aircraftType= AircraftType()
        aircraftType.iataMain="ABY"
        aircraftType.iataSub="ABY"
        flight.aircraftType=aircraftType
        flight.baggageClaim=null
        flight.checkinAllocations=null
        flight.codeshares=null
        flight.estimatedLandingTime=null
        flight.expectedTimeBoarding=null
        flight.expectedTimeGateClosing=null
        flight.expectedTimeGateOpen=null
        flight.expectedTimeOnBelt=null
        flight.expectedSecurityFilter=null
        flight.flightDirection="D"
        flight.flightName="MNB150"
        flight.flightNumber=150
        flight.gate=null
        flight.pier=null
        flight.id="126863734772419767"
        flight.mainFlight="MNB150"
        flight.prefixIATA="MB"
        flight.prefixICAO="MNB"
        flight.airlineCode=328
        flight.publicEstimatedOffBlockTime=null
        val publicFlightState= PublicFlightState()
        publicFlightState.flightStates= arrayListOf("DEP")
        flight.publicFlightState=publicFlightState
        val route=FlightRoute()
        route.destinations= arrayListOf("ISL")
        route.eu="N"
        route.visa=false
        flight.route=route
        flight.scheduleDateTime="2019-05-06T00:00:00.000+02:00"
        flight.scheduleDate="2019-05-06"
        flight.scheduleTime="00:00:00"
        flight.serviceType="F"
        flight.terminal=null
        flight.transferPositions=null
        flight.schemaVersion="4"
        var fl=listOf(flight)
        flight.route!!.destinations= arrayListOf("MXP")
        fl.plus(flight)
        fl.plus(flight)
        flight.route!!.destinations= arrayListOf("BUD")
        fl.plus(flight)
        flight.route!!.destinations= arrayListOf("LTN")
        fl.plus(flight)
        if (direction!=null) fl.filter { x-> x.route!!.destinations!!.contains(direction) }
        flights.flights=fl
        val call = object : Call<Flights> {
            @Throws(IOException::class)
            override fun execute(): Response<Flights> {
                return Response.success(flights)
            }

            override fun enqueue(callback: Callback<Flights>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<Flights> {
                return this
            }

            override fun request(): Request? {
                return null
            }
        }

        return call
    }

}
