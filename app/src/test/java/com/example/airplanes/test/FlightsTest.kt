package com.example.airplanes.test

import com.example.airplanes.model.Flight
import com.example.airplanes.testInjector
import com.example.airplanes.ui.flights.FlightsPresenter
import com.example.airplanes.ui.flights.FlightsScreen
import com.example.airplanes.utils.argumentCaptor

import com.example.airplanes.utils.mock
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.verify
import java.lang.Exception
import javax.inject.Inject

class FlightsTest {
    @Inject
    lateinit var flightsPresenter: FlightsPresenter

    private  lateinit var flightsScreen: FlightsScreen
    private lateinit var query: String

    @Before
    @Throws(Exception::class)
    fun setup(){
        testInjector.inject(this)
        flightsScreen= mock()
        flightsPresenter.attachScreen(flightsScreen)
    }

    @Test
    fun testDetails(){
        query="BUD"
        flightsPresenter.refreshFlights(query)

        val list= argumentCaptor<List<Flight>>()
        verify(flightsScreen).showFlights(list.capture())
        assert(list.value.size>0)


    }

    @After
    fun tearDown(){
        flightsPresenter.detachScreen()
    }
}