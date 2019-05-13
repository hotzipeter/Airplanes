package com.example.airplanes

import android.content.Context
import android.telecom.Call
import com.example.airplanes.interactor.database.DatabaseInteractor
import com.example.airplanes.interactor.favourites.FavouritesInteracor
import com.example.airplanes.interactor.flights.FlightsInteractor
import com.example.airplanes.ui.details.DetailsPresenter
import com.example.airplanes.ui.flights.FlightsPresenter
import com.example.airplanes.utils.UiExecutor
import dagger.Module
import dagger.Provides
import org.junit.Test

import org.junit.Assert.*
import java.util.concurrent.Executor
import javax.inject.Singleton

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@Module
class TestModule(private val context: Context) {

    @Provides
    fun provideContext() = context

    @Provides
    @Singleton
    fun provideFlightsPresenter(executor: Executor,flightsInteractor: FlightsInteractor,databaseInteractor: DatabaseInteractor,favouritesInteracor: FavouritesInteracor) = FlightsPresenter(executor,flightsInteractor,databaseInteractor, favouritesInteracor)

    @Provides
    @Singleton
    fun provideDetailsPresenter(executor: Executor, favouritesInteracor: FavouritesInteracor,databaseInteractor: DatabaseInteractor) = DetailsPresenter(executor, favouritesInteracor,databaseInteractor)

    @Provides
    @Singleton
    fun provideNetworkExecutor(): Executor = UiExecutor()
}

