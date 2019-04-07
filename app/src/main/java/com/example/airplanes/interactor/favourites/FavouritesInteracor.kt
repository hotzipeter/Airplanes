package com.example.airplanes.interactor.favourites

import com.example.airplanes.network.FavouritesApi
import javax.inject.Inject

class FavouritesInteracor @Inject constructor(private var FavouritesApi: FavouritesApi){
    fun postAirline(airline: String){}
    fun putAirline(airline: String){}
    fun deleteAirline(airline: String){}
}