package com.trinityjayd.biggerpicturenews.Apis

import com.trinityjayd.biggerpicturenews.Models.CurrencyModels.Currency
import com.trinityjayd.biggerpicturenews.Models.CurrencyModels.CurrencyApiResponse
import com.trinityjayd.biggerpicturenews.Models.WeatherModels.Weather
import retrofit2.Response
import retrofit2.http.GET

interface CurrencyApi {
    @GET("v1/currencies?apikey=fca_live_tmUizffKokTXHf3PaklPE7MbLNDmFJ1rAxg4jyxU")
    suspend fun getCurrencies(): Response<CurrencyApiResponse>
}