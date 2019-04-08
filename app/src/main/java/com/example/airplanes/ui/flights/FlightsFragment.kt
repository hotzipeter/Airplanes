package com.example.airplanes.ui.flights

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.airplanes.model.Flight
import javax.inject.Inject

class FlightsFragment: Fragment(), FlightsScreen {
    override fun showNetworkError(errorMsg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Inject
    lateinit var flightsPresenter: FlightsPresenter

    override fun showFlights(flights: List<Flight>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        flightsPresenter.attachScreen(this)
    }

    override fun onDetach() {
        flightsPresenter.detachScreen()
        super.onDetach()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}