package com.example.airplanes.interactor.favourites.event

data class ModifyFavourites (
    var code: Int = 0,
    var fav: String="",
    var throwable: Throwable? = null
)