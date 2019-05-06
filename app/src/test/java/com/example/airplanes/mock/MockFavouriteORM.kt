package com.example.airplanes.mock

import com.example.airplanes.model.room.FavouriteDAO
import com.example.airplanes.model.room.FavouritesORM

class MockFavouriteORM : FavouriteDAO {
    var favourites= listOf<FavouritesORM>(FavouritesORM(1,"WZZ"),FavouritesORM(2,"KLM"))
    override fun getAllGrades(): List<FavouritesORM> {
        return favourites
    }

    override fun getSpecificGrades(favourite: String): List<FavouritesORM> {
        return favourites.filter { x->x.favourite==favourite }
    }

    override fun insertGrades(vararg favourites: FavouritesORM) {
        this.favourites.plus(favourites)
    }

    override fun deleteGrade(favourite: FavouritesORM) {
        this.favourites.drop(this.favourites.indexOf(favourite))
    }
}