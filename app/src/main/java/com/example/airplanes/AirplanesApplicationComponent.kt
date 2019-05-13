package com.example.airplanes

import com.example.airplanes.interactor.InteractorModule
import com.example.airplanes.model.room.RoomModule
import com.example.airplanes.network.NetworkModule
import com.example.airplanes.ui.UIModule
import com.example.airplanes.ui.details.DetailsActivity
import com.example.airplanes.ui.flights.FlightsFragment
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [UIModule::class, NetworkModule::class, InteractorModule::class,RoomModule::class])
interface AirplanesApplicationComponent {
    fun inject(detailsActivity: DetailsActivity)
    fun inject(flightsFragment: FlightsFragment)
}