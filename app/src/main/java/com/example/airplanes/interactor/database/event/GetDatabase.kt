package com.example.airplanes.interactor.database.event

data class GetDatabase (
    var fav: List<String>?=null,
    var throwable: Throwable? = null
)