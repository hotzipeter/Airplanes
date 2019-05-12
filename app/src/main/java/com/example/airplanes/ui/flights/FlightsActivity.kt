package com.example.airplanes.ui.flights



import android.os.Bundle

import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.example.airplanes.R
import kotlinx.android.synthetic.main.fragment_flights.*
import javax.inject.Inject


class FlightsActivity: AppCompatActivity(){

   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_flights)
        supportFragmentManager.beginTransaction().replace(R.id.fragment, FlightsFragment.newInstance()).commit()


   }

}