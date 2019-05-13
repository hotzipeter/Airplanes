package com.example.airplanes.network

import com.example.airplanes.model.Flights
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Query

interface FlightsApi {
    @GET("flights")

    fun getFlights(
        @HeaderMap() authorisation: Map<String,String>,
        @Query("flightDirection") direction: String,
        @Query("fromDateTime") fromDate: String,
        @Query("toDateTime") toDate: String,
        @Query("searchDateTimeField") sch: String
        ): Call<Flights>

    @GET("flights")
    fun getFlightsWithDirection(
        @HeaderMap() authorisation: Map<String,String>,
        @Query("flightDirection") direction: String,
        @Query("route") route: String?,
        @Query("fromDateTime") fromDate: String,
        @Query("toDateTime") toDate: String,
        @Query("searchDateTimeField") sch: String
    ): Call<Flights>
}