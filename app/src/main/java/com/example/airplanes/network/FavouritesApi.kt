package com.example.airplanes.network

import retrofit2.http.*

interface FavouritesApi {
    @GET("airlines")
    fun getAirline(
        @Header("Authorization") authorisation: String,
        @Query("airline") airline: String?
    ): Unit

    @DELETE("airlines")
    fun deleteAirline(
        @Header("Authorization") authorization: String,
        @Query("airline") airline: String
    ): Unit

    @POST("airlines")
    @FormUrlEncoded
    fun postAirline(
        @Header("Authorization") authorization: String,
        @Field("airline") airline: String
    ): Unit

    @PUT
    fun putAirline(
        @Header("Authorization") authorization: String,
        @Field("airline") airline: String
    ): Unit
}