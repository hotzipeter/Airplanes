package com.example.airplanes.model

import com.google.gson.annotations.SerializedName

class Flight {
    @SerializedName("lastUpdatedAt")
    var lastUpdatedAt: String? = null
    @SerializedName("actualLandingTime")
    var actualLandingTime: String? = null
    @SerializedName("actualOffBlockTime")
    var actualOffBlockTime: String? = null
    @SerializedName("aircraftRegistration")
    var aircraftRegistration: String? = null
    @SerializedName("actualLandingTime")
    var aircraftType: AircraftType? = null
    @SerializedName("baggageClaim")
    var baggageClaim: BaggageClaim? = null
    @SerializedName("checkinAllocations")
    var checkinAllocations: CheckinAllocations? = null
    @SerializedName("codeshares")
    var codeshares: CodeShares? = null
    @SerializedName("estimatedLandingTime")
    var estimatedLandingTime: String? = null
    @SerializedName("expectedTimeBoarding")
    var expectedTimeBoarding: String? = null
    @SerializedName("expectedTimeGateClosing")
    var expectedTimeGateClosing: String? = null
    @SerializedName("expectedTimeGateOpen")
    var expectedTimeGateOpen: String? = null
    @SerializedName("expectedTimeOnBelt")
    var expectedTimeOnBelt: String? = null
    @SerializedName("expectedSecurityFilter")
    var expectedSecurityFilter: String? = null
    @SerializedName("flightDirection")
    var flightDirection: String? = null
    @SerializedName("flightName")
    var flightName: String? = null
    @SerializedName("flightNumber")
    var flightNumber: Int? = null
    @SerializedName("gate")
    var gate: String? = null
    @SerializedName("pier")
    var pier: String? = null
    @SerializedName("id")
    var id: String? = null
    @SerializedName("mainFlight")
    var mainFlight: String? = null
    @SerializedName("prefixIATA")
    var prefixIATA: String? = null
    @SerializedName("prefixICAO")
    var prefixICAO: String? = null
    @SerializedName("airlineCode")
    var airlineCode: Int? = null
    @SerializedName("publicEstimatedOffBlockTime")
    var publicEstimatedOffBlockTime: String? = null
    @SerializedName("publicFlightState")
    var publicFlightState: PublicFlightState? = null
    @SerializedName("route")
    var route: FlightRoute? = null
    @SerializedName("scheduleDateTime")
    var scheduleDateTime: String? = null
    @SerializedName("scheduleDate")
    var scheduleDate: String? = null
    @SerializedName("scheduleTime")
    var scheduleTime: String? = null
    @SerializedName("serviceType")
    var serviceType: String? = null
    @SerializedName("terminal")
    var terminal: Int? = null
    @SerializedName("transferPositions")
    var transferPositions: TransferPositions? = null
    @SerializedName("schemaVersion")
    var schemaVersion: String? = null
}