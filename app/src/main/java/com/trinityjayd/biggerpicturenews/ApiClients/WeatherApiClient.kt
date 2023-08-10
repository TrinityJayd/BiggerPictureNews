package com.trinityjayd.biggerpicturenews.ApiClients

import com.trinityjayd.biggerpicturenews.Apis.WeatherApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WeatherApiClient {
    private const val BASE_URL = "http://dataservice.accuweather.com/"

    fun getClient(): WeatherApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(WeatherApi::class.java)
    }
}