package com.example.airplanes.mock

import com.example.airplanes.network.FavouritesApi
import io.swagger.client.models.Favourite
import io.swagger.client.models.Favourites

class MockFavouritesApi: FavouritesApi{
    var favourites= arrayOf( "WZZ", "KLM")
    override fun addFavourite(addFavourite: Favourite) {
       favourites.set(favourites.size, addFavourite.airline!!)
    }

    override fun deleteFavourties(favourite: String) {
        favourites.drop(favourites.indexOf(favourite))
    }

    override fun getFavourite(favourite: String): String {
        if (favourites.indexOf(favourite)>=0) return "Found"
        else return "Not found"
    }

    override fun getFavourites(): Favourites {
        return Favourites(favourites)
    }

    override fun postFavourties(favourites: Favourites) {
        this.favourites= favourites.airlines!!
    }



}