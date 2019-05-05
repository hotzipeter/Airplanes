package com.example.airplanes.model.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "favourites")
data class FavouritesORM(
    @PrimaryKey(autoGenerate = true) var favouriteId: Long?,
    @ColumnInfo(name = "favourite") var favourite: String
)