package com.trinityjayd.biggerpicturenews.Apis

import com.trinityjayd.biggerpicturenews.Models.WeatherModels.Weather
import retrofit2.Response
import retrofit2.http.GET

interface WeatherApi {
    @GET("currentconditions/v1/305605?apikey=BEd0AW1JSwB1Z4FbfpT26FI40KLSYqqv")
    suspend fun getWeather(): Response<List<Weather>>
}