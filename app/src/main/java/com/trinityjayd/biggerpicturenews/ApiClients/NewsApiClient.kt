package com.trinityjayd.biggerpicturenews.ApiClients

import com.trinityjayd.biggerpicturenews.Apis.NewsApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NewsApiClient {

    private const val BASE_URL = "https://newsapi.org/v2/"

    fun getClient(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(NewsApi::class.java)
    }
}