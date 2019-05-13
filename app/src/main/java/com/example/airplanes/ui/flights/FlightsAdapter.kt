package com.example.airplanes.ui.flights

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.airplanes.R
import com.example.airplanes.model.Flight
import kotlinx.android.synthetic.main.card_flight.view.*

class FlightsAdapter constructor(
    private val context: Context,
    private var flights: List<Flight>,
    protected var airlines: List<String>?,
    private val listener: (Flight) -> Unit) : RecyclerView.Adapter<FlightsAdapter.ViewHolder>() {

    fun setAi(a: List<String>){
        airlines=a
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val flightView = LayoutInflater.from(context).inflate(R.layout.card_flight, viewGroup, false)
        return ViewHolder(flightView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)= holder.bind(flights[position], listener,airlines)


    override fun getItemCount() = flights.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Flight, listener: (Flight) -> Unit,airlines: List<String>?) = with(itemView) {
            tvDeptTime.text =item.scheduleTime
            tvCode.text=item.flightName
            tvRoute.text= item.route?.destinations.toString()
            if (airlines != null) {
                if (airlines.contains(item.prefixICAO))
                    Glide.with(context).load(android.R.drawable.btn_star_big_on).into(ivFavourite)
                else Glide.with(context).load(android.R.drawable.btn_star_big_off).into(ivFavourite)
                Log.d("adapter",(airlines.contains(item.prefixICAO).toString()))
            }
            else Glide.with(context).load(android.R.drawable.btn_star_big_off).into(ivFavourite)
            setOnClickListener { listener(item) }
        }
    }
}