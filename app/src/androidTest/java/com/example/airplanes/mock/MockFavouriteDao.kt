package com.example.airplanes.mock

import com.example.airplanes.model.room.FavouriteDAO
import com.example.airplanes.model.room.FavouritesORM

class MockFavouriteDao : FavouriteDAO {
    var favourites= listOf<String>("WZZ","KLM")
    override fun getAllGrades(): List<String> {
        return favourites
    }

    override fun getSpecificGrades(favourite: String): List<String> {
        return favourites.filter { x->x==favourite }
    }

    override fun insertGrades(vararg favourites: FavouritesORM) {

        this.favourites.plus(favourites.map { x->x.favourite })
    }

    override fun deleteGrade(favourite: FavouritesORM) {
        this.favourites.drop(this.favourites.indexOf(favourite.favourite))
    }
}