package com.example.airplanes.ui.flights

import com.example.airplanes.interactor.database.DatabaseInteractor
import com.example.airplanes.interactor.database.event.GetDatabase
import com.example.airplanes.interactor.favourites.FavouritesInteracor
import com.example.airplanes.interactor.flights.FlightsInteractor
import com.example.airplanes.interactor.flights.event.GetFlightsEvent
import com.example.airplanes.model.Flight
import com.example.airplanes.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import javax.inject.Inject
import java.util.concurrent.Executor

class FlightsPresenter @Inject constructor(private val executor: Executor,private val flightsInteractor: FlightsInteractor, private  val databaseInteractor: DatabaseInteractor,private  val favouritesInteracor: FavouritesInteracor): Presenter<FlightsScreen>(){
    override fun attachScreen(screen: FlightsScreen) {
        EventBus.getDefault().register(this)
        super.attachScreen(screen)

    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun refreshFlights(route: String) {
        executor.execute {
            flightsInteractor.getFlights("D",route)
        }
    }

    fun getFlights() {
        var s:List<String>
        executor.execute {
            databaseInteractor.getAllGrades()
        }

    }
    fun putAirline(airline: Array<String>) {
        executor.execute {
            favouritesInteracor.putAirline(airline)
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetFlightsEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showNetworkError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.flights != null) {
                    screen?.showFlights(event.flights as MutableList<Flight>)
                }

            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetDatabase) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showNetworkError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.fav != null) {
                    screen?.setFavourites(event.fav!!)
                }

            }
        }
    }
}