package com.example.airplanes

import com.example.airplanes.interactor.InteractorModule
import com.example.airplanes.mock.MockNetworkModule
import com.example.airplanes.mock.MockRoomModule
import com.example.airplanes.test.DetailsTest
import com.example.airplanes.test.FlightsTest
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MockNetworkModule::class, TestModule::class, InteractorModule::class, MockRoomModule::class])
interface TestComponent {
    fun inject(detailsTest: DetailsTest)
    fun inject(flightsTest: FlightsTest)
}
