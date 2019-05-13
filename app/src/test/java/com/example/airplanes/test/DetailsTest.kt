package com.example.airplanes.test

import com.example.airplanes.testInjector
import com.example.airplanes.ui.details.DetailsPresenter
import com.example.airplanes.ui.details.DetailsScreen
import com.example.airplanes.utils.mock
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.lang.Exception
import javax.inject.Inject

class DetailsTest {
    @Inject
    lateinit var detailsPresenter: DetailsPresenter

    private  lateinit var detailsScreen: DetailsScreen
    private lateinit var query: String

    @Before
    @Throws(Exception::class)
    fun setup(){
        testInjector.inject(this)
        detailsScreen= mock()
        detailsPresenter.attachScreen(detailsScreen)
    }

    @Test
    fun testDetails(){
        query="KLM"
        detailsPresenter.changefavourite(query,0)
        detailsPresenter.changefavourite(query,1)


    }

    @After
    fun tearDown(){
        detailsPresenter.detachScreen()
    }

}