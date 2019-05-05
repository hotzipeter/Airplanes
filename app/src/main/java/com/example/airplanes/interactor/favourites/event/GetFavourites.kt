package com.example.airplanes.interactor.favourites.event

data class GetFavourites (
    var code: Int = 0,
    var fav: Collection<String>?=null,
    var throwable: Throwable? = null
)