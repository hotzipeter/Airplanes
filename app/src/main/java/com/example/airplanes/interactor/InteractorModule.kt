package com.example.airplanes.interactor

import com.example.airplanes.interactor.database.DatabaseInteractor
import com.example.airplanes.interactor.favourites.FavouritesInteracor
import com.example.airplanes.interactor.flights.FlightsInteractor
import com.example.airplanes.model.room.FavouriteDAO
import com.example.airplanes.network.FavouritesApi

import com.example.airplanes.network.FlightsApi
import com.example.airplanes.network.FlightsPageApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideFlightsInteractor(flightsApi: FlightsApi,flightsPageApi: FlightsPageApi) = FlightsInteractor(flightsApi,flightsPageApi)

    @Provides
    @Singleton
    fun provideFavouritesInteractor(favouritesApi: FavouritesApi) = FavouritesInteracor(favouritesApi)

    @Provides
    @Singleton
    fun provideDatabaseInteractor(favouriteDAO: FavouriteDAO) = DatabaseInteractor(favouriteDAO)

}