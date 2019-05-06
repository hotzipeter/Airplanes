package com.example.airplanes.interactor.favourites


import com.android.volley.Response
import com.example.airplanes.interactor.favourites.event.GetFavourites
import com.example.airplanes.interactor.favourites.event.ModifyFavourites
import io.swagger.client.apis.DefaultApi

import io.swagger.client.models.Favourite
import io.swagger.client.models.Favourites
import org.greenrobot.eventbus.EventBus

class FavouritesInteracor  constructor(){
    fun postAirline(airline: String)
    {
        var apiInstance = DefaultApi()
        var fav= Favourite(airline)



        apiInstance.addFavourite(fav)
    }
    fun putAirline(airlines: Array<String>){
        var apiInstance = DefaultApi()
        var favs= Favourites(airlines)


        apiInstance.postFavourties(favs)
    }
    fun deleteAirline(airline: String){
        var apiInstance = DefaultApi()
        apiInstance.deleteFavourties(airline)
    }

    fun getAirlineIsFavourite(airline: String){
        var apiInstance = DefaultApi()

        var resp=apiInstance.getFavourite(airline)
        var event=ModifyFavourites()
        event.code=200
        event.fav=resp
        EventBus.getDefault().post(event)
    }

    fun getFavourites(favourites: Collection<String>){
        var apiInstance = DefaultApi()

        var resp=apiInstance.getFavourites()
        var event=GetFavourites()
        event.code=200
        event.fav=resp
        EventBus.getDefault().post(event)
    }
}