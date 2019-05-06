package com.example.airplanes.interactor.favourites


import com.example.airplanes.interactor.favourites.event.GetFavourites
import com.example.airplanes.interactor.favourites.event.ModifyFavourites
import com.example.airplanes.network.FavouritesApi
import io.swagger.client.apis.DefaultApi

import io.swagger.client.models.Favourite
import io.swagger.client.models.Favourites
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class FavouritesInteracor  @Inject constructor(private val favouritesApi: FavouritesApi) {
    fun postAirline(airline: String)
    {
        var fav= Favourite(airline)
        favouritesApi.addFavourite(fav)
    }
    fun putAirline(airlines: Array<String>){

        var favs= Favourites(airlines)
        favouritesApi.postFavourties(favs)
    }
    fun deleteAirline(airline: String){
        favouritesApi.deleteFavourties(airline)
    }

    fun getAirlineIsFavourite(airline: String){


        var resp=favouritesApi.getFavourite(airline)
        var event=ModifyFavourites()
        event.code=200
        event.fav=resp
        EventBus.getDefault().post(event)
    }

    fun getFavourites(){
        var apiInstance = DefaultApi()

        var resp=apiInstance.getFavourites()
        var event=GetFavourites()
        event.code=200
        event.fav=resp
        EventBus.getDefault().post(event)
    }
}