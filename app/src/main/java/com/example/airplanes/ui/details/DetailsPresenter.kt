package com.example.airplanes.ui.details

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.airplanes.interactor.database.DatabaseInteractor
import com.example.airplanes.interactor.favourites.FavouritesInteracor
import com.example.airplanes.interactor.favourites.event.ModifyFavourites
import com.example.airplanes.interactor.flights.FlightsInteractor
import com.example.airplanes.interactor.flights.event.GetFlightsEvent
import com.example.airplanes.model.Flight
import com.example.airplanes.model.room.FavouritesORM
import com.example.airplanes.ui.Presenter
import com.example.airplanes.ui.flights.FlightsScreen
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class DetailsPresenter @Inject constructor(private val executor: Executor,private val favouriteInteractor: FavouritesInteracor,
                                           private val databaseInteractor: DatabaseInteractor): Presenter<DetailsScreen>(){

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
            databaseInteractor.deleteGrade(airline)
        }
    }
    fun postAirline(airline: String) {
        executor.execute {
            favouriteInteractor.postAirline(airline)
            databaseInteractor.insertGrades(FavouritesORM(null,airline))
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
                    screen?.changeButtonImg(1)
                }

            }
        }
    }


    fun showFlightDetails(intent: Intent){
        screen?.showFlightDetail(intent)
    }

    fun changefavourite(stringExtra: String?,i: Int) {
        Log.d("fav",stringExtra)
        Log.d("fav",i.toString())
        if (i==0){
            postAirline(stringExtra!!)
            screen?.changeButtonImg(0)
        }else{
            deleteAirline(stringExtra!!)
            screen?.changeButtonImg(1)
        }
    }
}