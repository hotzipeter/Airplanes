package com.example.airplanes.interactor.database

import com.example.airplanes.interactor.database.event.GetDatabase
import com.example.airplanes.model.room.FavouriteDAO
import com.example.airplanes.model.room.FavouritesORM
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class DatabaseInteractor @Inject constructor(private val favouritesDao: FavouriteDAO) {


    fun getAllGrades(){
        var favs=favouritesDao.getAllGrades()
        val event = GetDatabase()
        event.fav=favs
        EventBus.getDefault().post(event)
    }
    fun getSpecificGrades(favourite: String): List<FavouritesORM>{
        return favouritesDao.getSpecificGrades(favourite)
    }

    fun insertGrades(vararg favourites: FavouritesORM){
        favouritesDao.insertGrades(*favourites)
    }

    fun deleteGrade(favourite: String){
        for (v in getSpecificGrades(favourite))
        favouritesDao.deleteGrade(v)
    }
}