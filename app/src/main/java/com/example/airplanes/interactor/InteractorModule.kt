package com.example.airplanes.interactor

import com.example.airplanes.interactor.favourites.FavouritesInteracor
import com.example.airplanes.interactor.flights.FlightsInteractor
import com.example.airplanes.model.Flights
import com.example.airplanes.network.FavouritesApi
import com.example.airplanes.network.FlightsApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideFlightsInteractor(flightsApi: FlightsApi) = FlightsInteractor(flightsApi)

    @Provides
    @Singleton
    fun provideFavouritesInteractor(favouritesApi: FavouritesApi) = FavouritesInteracor(favouritesApi)

}