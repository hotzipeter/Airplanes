package com.example.airplanes.network

import io.swagger.client.models.Favourite
import io.swagger.client.models.Favourites


interface FavouritesApi {

    fun addFavourite(addFavourite: Favourite):Unit


    fun deleteFavourties(favourite: kotlin.String) : Unit


    fun getFavourite(favourite: kotlin.String) : kotlin.String


    fun getFavourites() : Favourites
    fun postFavourties(favourites: Favourites) : Unit
}