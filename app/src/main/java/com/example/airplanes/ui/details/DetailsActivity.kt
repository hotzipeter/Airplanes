package com.example.airplanes.ui.details

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.airplanes.R
import com.example.airplanes.injector
import com.example.airplanes.model.Flight
import kotlinx.android.synthetic.main.activity_details.*
import javax.inject.Inject

class DetailsActivity: AppCompatActivity(),DetailsScreen {
    override fun showFlightDetail(intent: Intent) {
        textView11.text=intent.getStringExtra("Code")
        textView7.text=intent.getStringExtra("Route")
        textView9.text=intent.getStringExtra("Airline")
        textView4.text=intent.getStringExtra("Departure")
        if(intent.getBooleanExtra("Favourite",false))changeButtonImg(0)
        else changeButtonImg(1)
    }

    override fun changeButtonImg(state: Int) {
        if (state==0){
            favouriteButton.setImageResource(android.R.drawable.btn_star_big_on)
            i=1
        }else{
            favouriteButton.setImageResource(android.R.drawable.btn_star_big_off)
            i=0
        }
    }

    override fun showNetworkError(errorMsg: String) {

    }

    @Inject
    lateinit var detailsPresenter: DetailsPresenter
    var i=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_details)
        injector.inject(this)
        showFlightDetail(intent)
        favouriteButton.setOnClickListener {
           detailsPresenter.changefavourite(intent.getStringExtra("Airline"),i)
        }
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