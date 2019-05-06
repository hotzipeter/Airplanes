package com.example.airplanes.mock

import com.example.airplanes.network.FavouritesApi
import com.example.airplanes.network.FlightsApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
class MockNetworkModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Provides
    @Singleton
    fun favouritesArtistsApi(): FavouritesApi = MockFavouritesApi()

    @Provides
    @Singleton
    fun provideFlightsApi(): FlightsApi = MockFlightsApi()
}
