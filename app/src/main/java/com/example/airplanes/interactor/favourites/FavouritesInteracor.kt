package com.example.airplanes.interactor.favourites

import io.swagger.client.api.DefaultApi
import io.swagger.client.model.Favourite
import com.android.volley.Response
import com.example.airplanes.interactor.favourites.event.GetFavourites
import com.example.airplanes.interactor.favourites.event.ModifyFavourites
import io.swagger.client.model.Favourites
import org.greenrobot.eventbus.EventBus

class FavouritesInteracor  constructor(){
    fun postAirline(airline: String)
    {
        var apiInstance = DefaultApi()
        var fav=Favourite()

        fav.airline=airline
        apiInstance.addFavourite(fav)
    }
    fun putAirline(airlines: Collection<String>){
        var apiInstance = DefaultApi()
        var favs= Favourites()

        favs.addAll(airlines)
        apiInstance.postFavourties(favs)
    }
    fun deleteAirline(airline: String){
        var apiInstance = DefaultApi()
        apiInstance.deleteFavourties(airline)
    }

    fun getAirlineIsFavourite(airline: String){
        var apiInstance = DefaultApi()
        var listener=Response.Listener<String>(){
            x->
            run {
                val event = ModifyFavourites()
                event.code=200
                event.fav=x
                EventBus.getDefault().post(event)
            }
        }
        var err=Response.ErrorListener { x->run {
            val event = ModifyFavourites()
            event.code=x.networkResponse.statusCode

            EventBus.getDefault().post(event)
        } }
        apiInstance.getFavourite(airline,listener,err)
    }

    fun getFavourites(favourites: Collection<String>){
        var apiInstance = DefaultApi()
        var listener=Response.Listener<Favourites>(){
                x->
            run {
                val event = GetFavourites()
                event.code=200
                event.fav=x
                EventBus.getDefault().post(event)
            }
        }
        var err=Response.ErrorListener { x->run {
            val event = ModifyFavourites()
            event.code=x.networkResponse.statusCode

            EventBus.getDefault().post(event)
        } }
        apiInstance.getFavourites(listener,err)
    }
}