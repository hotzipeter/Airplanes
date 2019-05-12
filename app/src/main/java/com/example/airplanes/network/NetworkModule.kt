package com.example.airplanes.network

import dagger.Module
import dagger.Provides
import io.swagger.client.apis.DefaultApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Provides
    @Singleton
    fun provideFlightsApi(client: OkHttpClient): FlightsApi {
        val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(NetworkConfig.FLIGHT_API_ENDPOINT_ADDRESS)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(FlightsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideFlightsPageApi(client: OkHttpClient): FlightsPageApi{
        val retrofit=Retrofit.Builder().client(client).baseUrl(NetworkConfig.FLIGHT_PAGE_API_ENDPOINT_ADDRESS)
            .addConverterFactory(GsonConverterFactory.create()).build()
        return retrofit.create(FlightsPageApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAirlineApi(): FavouritesApi {

        return DefaultApi()
    }
}