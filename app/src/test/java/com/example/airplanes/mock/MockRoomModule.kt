package com.example.airplanes.mock

import android.content.Context
import com.example.airplanes.model.room.FavouriteDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MockRoomModule {
    @Provides
    @Singleton
    fun provideFlightsApi(context: Context):FavouriteDAO=MockFavouriteDao()
}