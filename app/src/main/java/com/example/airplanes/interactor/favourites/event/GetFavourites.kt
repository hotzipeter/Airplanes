package com.example.airplanes.interactor.favourites.event

import io.swagger.client.models.Favourites

data class GetFavourites (
    var code: Int = 0,
    var fav: Favourites?=null,
    var throwable: Throwable? = null
)