package com.example.airplanes.interactor.favourites.event

import io.swagger.client.models.Favourite

data class ModifyFavourites (
    var code: Int = 0,
    var fav: String?=null,
    var throwable: Throwable? = null
)