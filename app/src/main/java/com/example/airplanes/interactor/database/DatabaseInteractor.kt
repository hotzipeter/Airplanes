package com.example.airplanes.interactor.database

import com.example.airplanes.model.room.FavouriteDAO
import com.example.airplanes.model.room.FavouritesORM
import javax.inject.Inject

class DatabaseInteractor @Inject constructor(private val favouritesDao: FavouriteDAO) {


    fun getAllGrades():List<String>{
        return favouritesDao.getAllGrades()
    }
    fun getSpecificGrades(favourite: String): List<String>{
        return favouritesDao.getSpecificGrades(favourite)
    }

    fun insertGrades(vararg favourites: FavouritesORM){
        favouritesDao.insertGrades(*favourites)
    }

    fun deleteGrade(favourite: FavouritesORM){
        favouritesDao.deleteGrade(favourite)
    }
}