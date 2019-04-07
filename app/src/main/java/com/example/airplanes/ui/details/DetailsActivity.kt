package com.example.airplanes.ui.details

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.airplanes.model.Flight
import javax.inject.Inject

class DetailsActivity: AppCompatActivity(),DetailsScreen {
    override fun showFlightDetail(flight: Flight) {

    }

    @Inject
    lateinit var detailsPresenter: DetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onStart() {
        super.onStart()
        detailsPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        detailsPresenter.detachScreen()
    }
}