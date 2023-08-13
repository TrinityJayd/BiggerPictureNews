package com.trinityjayd.biggerpicturenews.Apis

import com.trinityjayd.biggerpicturenews.Models.WeatherModels.Weather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("currentconditions/v1/305605")
    suspend fun getWeather(
        @Query("apikey") apiKey: String
    ): Response<List<Weather>>
}