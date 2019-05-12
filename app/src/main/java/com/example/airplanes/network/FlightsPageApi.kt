package com.example.airplanes.network

import com.example.airplanes.model.Flights
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Query

interface FlightsPageApi  {
    @GET("flights")
    fun getFlightsWithPages(
        @HeaderMap() authorisation: Map<String,String>,
        @Query("flightDirection") direction: String,
        @Query("fromDateTime") fromDate: String,
        @Query("toDateTime") toDate: String,
        @Query("searchDateTimeField") sch: String,
        @Query("page") pages: Int
    ): Call<Flights>

    @GET("flights")
    fun getFlightsWithRouteAndPages(
        @HeaderMap() authorisation: Map<String,String>,
        @Query("flightDirection") direction: String,
        @Query("route") route: String?,
        @Query("fromDateTime") fromDate: String,
        @Query("toDateTime") toDate: String,
        @Query("searchDateTimeField") sch: String,
        @Query("page") pages: Int
    ): Call<Flights>
}