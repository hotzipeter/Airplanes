package com.example.airplanes.ui.details

import com.example.airplanes.interactor.favourites.FavouritesInteracor
import com.example.airplanes.interactor.favourites.event.ModifyFavourites
import com.example.airplanes.interactor.flights.FlightsInteractor
import com.example.airplanes.interactor.flights.event.GetFlightsEvent
import com.example.airplanes.model.Flight
import com.example.airplanes.ui.Presenter
import com.example.airplanes.ui.flights.FlightsScreen
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class DetailsPresenter @Inject constructor(private val executor: Executor,private val favouriteInteractor: FavouritesInteracor): Presenter<DetailsScreen>(){

    override fun attachScreen(screen: DetailsScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }
    fun deleteAirline(airline: String) {
        executor.execute {
            favouriteInteractor.deleteAirline(airline)
        }
    }
    fun postAirline(airline: String) {
        executor.execute {
            favouriteInteractor.postAirline(airline)
        }
    }
    fun putAirline(airline: String) {
        executor.execute {
            favouriteInteractor.putAirline(airline)
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: ModifyFavourites) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showNetworkError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.code != null) {
                    screen?.changeButtonImg()
                }

            }
        }
    }


    fun showFlightDetails(flight: Flight){
        screen?.showFlightDetail(flight)
    }
}