package com.example.airplanes.ui

import android.content.Context
import com.example.airplanes.interactor.database.DatabaseInteractor
import com.example.airplanes.interactor.favourites.FavouritesInteracor
import com.example.airplanes.interactor.flights.FlightsInteractor
import com.example.airplanes.ui.details.DetailsPresenter
import com.example.airplanes.ui.flights.FlightsPresenter
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class UIModule(private val context: Context)  {
    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun flightPresenter(executor: Executor, flightsInteractor: FlightsInteractor, databaseInteractor: DatabaseInteractor,favouritesInteractor: FavouritesInteracor)= FlightsPresenter(executor,flightsInteractor,databaseInteractor,favouritesInteractor)

    @Provides
    @Singleton
    fun detailsPresenter(executor: Executor, favouritesInteractor: FavouritesInteracor,databaseInteractor: DatabaseInteractor)=DetailsPresenter(executor,favouritesInteractor,databaseInteractor)

    @Provides
    @Singleton
    fun networkExecutor(): Executor = Executors.newFixedThreadPool(1)
}