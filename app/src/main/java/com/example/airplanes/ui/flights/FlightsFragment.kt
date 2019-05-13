package com.example.airplanes.ui.flights

import android.content.Context
import android.content.Intent
import android.os.Bundle

import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.airplanes.R
import com.example.airplanes.injector
import com.example.airplanes.model.Flight
import com.example.airplanes.ui.details.DetailsActivity
import com.example.airplanes.ui.utils.hide
import com.example.airplanes.ui.utils.show
import kotlinx.android.synthetic.main.fragment_flights.*

import javax.inject.Inject

class FlightsFragment: Fragment(), FlightsScreen {
    override fun setFavourites(favs:List<String>) {
        favourites=favs
        flightAdapter?.setAi(favourites!!)
    }

    private val displayedFlights: MutableList<Flight> = mutableListOf()
    private var flightAdapter: FlightsAdapter? = null
    private var favourites: List<String>?=null

    private var selectedFlight: String? = ""

    override fun showNetworkError(errorMsg: String) {
        System.err.print(errorMsg)
    }

    @Inject
    lateinit var flightsPresenter: FlightsPresenter

    override fun showFlights(flights: List<Flight>) {
        Log.i("Fragment",flights.size.toString())
        swipeRefreshLayoutFlights.isRefreshing = false

        displayedFlights.clear()
        if (flights != null) {
            displayedFlights.addAll(flights)
        }
        flightAdapter?.notifyDataSetChanged()

        if (displayedFlights.isEmpty()) {
            recyclerViewFlights.hide()
            tvEmpty.show()
        } else {
            recyclerViewFlights.show()
            tvEmpty.hide()
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
        flightsPresenter.attachScreen(this)


    }



    override fun onDetach() {
        flightsPresenter.detachScreen()
        super.onDetach()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_flights, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        flightsPresenter.getFlights()
        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        recyclerViewFlights.layoutManager = llm

        flightAdapter = FlightsAdapter(context!!, displayedFlights, favourites){
            Log.d("click",favourites.toString()+it.prefixICAO)
            val intent = Intent(context, DetailsActivity::class.java).apply {
                putExtra("Code",it.flightName)
                putExtra("Departure",it.scheduleTime)
                putExtra("Airline",it.prefixICAO)
                putExtra("Route", it.route?.destinations.toString())
                putExtra("Favourite", favourites?.contains(it.prefixICAO))
            }
            startActivity(intent)
        }
        favourites?.toTypedArray()?.let { flightsPresenter.putAirline(it) }
        recyclerViewFlights.adapter = flightAdapter
        flightsPresenter.refreshFlights(selectedFlight!!)
        btnFilter.setOnClickListener {
             flightsPresenter.refreshFlights(etFlight.text.toString().toUpperCase())  }
        swipeRefreshLayoutFlights.setOnRefreshListener {
            selectedFlight = etFlight.text.toString()
            flightsPresenter.refreshFlights(selectedFlight!!)
        }
    }

    override fun onResume() {
        super.onResume()
        selectedFlight = etFlight.text.toString()
        flightsPresenter.getFlights()
        flightsPresenter.refreshFlights(selectedFlight!!)
    }

    companion object {


        fun newInstance(): FlightsFragment {
            val fragment = FlightsFragment()
            val bundle = Bundle()


            fragment.arguments = bundle
            return fragment
        }
    }
}