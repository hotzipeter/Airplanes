package com.example.airplanes.model.room

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {
    @Provides
    @Singleton
    fun provideFlightsApi(context: Context): FavouriteDAO {
        return AppDatabase.getInstance(context).favouriteDao()
    }
}