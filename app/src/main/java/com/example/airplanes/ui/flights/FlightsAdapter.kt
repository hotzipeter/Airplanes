package com.example.airplanes.ui.flights

import android.content.Context
import android.support.v7.widget.RecyclerView
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
    private val listener: (Flight) -> Unit) : RecyclerView.Adapter<FlightsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val flightView = LayoutInflater.from(context).inflate(R.layout.card_flight, viewGroup, false)
        return ViewHolder(flightView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)= holder.bind(flights[position], listener)
    /*{
        val flight = flights[position]

        Glide.with(context).load(android.R.drawable.btn_star_big_off).into(holder.ivImage)
        holder.tvCode.text = flight.flightName
        holder.tvDepTime.text = flight.scheduleTime
        holder.tvRoute.text= flight.route?.destinations.toString()
    }*/

    override fun getItemCount() = flights.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        /*var tvDepTime: TextView = view.tvDeptTime
        var tvRoute: TextView = view.tvRoute
        var tvCode: TextView = view.tvCode
        var ivImage: ImageView = view.ivFavourite*/
        fun bind(item: Flight, listener: (Flight) -> Unit) = with(itemView) {
            tvDeptTime.text =item.scheduleTime
            tvCode.text=item.flightName
            tvRoute.text= item.route?.destinations.toString()

            Glide.with(context).load(android.R.drawable.btn_star_big_off).into(ivFavourite)
            setOnClickListener { listener(item) }
        }
    }
}