package com.trinityjayd.biggerpicturenews.ApiClients

import com.trinityjayd.biggerpicturenews.Apis.CurrencyApi
import com.trinityjayd.biggerpicturenews.Apis.WeatherApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CurrencyApiClient {
    private const val BASE_URL = "https://api.freecurrencyapi.com/"

    fun getClient(): CurrencyApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(CurrencyApi::class.java)
    }
}