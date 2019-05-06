package com.example.airplanes.model.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface FavouriteDAO {

    @Query("SELECT favourite FROM favourites")
    fun getAllGrades(): List<String>
    @Query("SELECT favourite FROM favourites WHERE favourite = :favourite")
    fun getSpecificGrades(favourite: String): List<String>
    @Insert
    fun insertGrades(vararg favourites: FavouritesORM)
    @Delete
    fun deleteGrade(favourite: FavouritesORM)
}