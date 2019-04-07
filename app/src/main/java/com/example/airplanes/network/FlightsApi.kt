package com.example.airplanes.network

import com.example.airplanes.model.Flights
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface FlightsApi {
    @GET("search")
    fun getArtists(
        @Header("Authorization") authorisation: String,
        @Query("flightDirection") direction: String,
        @Query("fromDate") fromDate: String,
        @Query("toDate") toDate: String,
        @Query("route") route: String
        ): Call<Flights>
}