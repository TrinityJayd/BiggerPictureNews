package com.trinityjayd.biggerpicturenews.Apis

import com.trinityjayd.biggerpicturenews.Models.WeatherModels.Weather
import retrofit2.Response
import retrofit2.http.GET

interface WeatherApi {
    @GET("currentconditions/v1//305605?apikey=DRZFEymi8l0Sj7RGtXepH4Gn9OiYErSi")
    suspend fun getWeather(): Response<List<Weather>>
}