package com.trinityjayd.biggerpicturenews.Apis

import com.trinityjayd.biggerpicturenews.Models.CurrencyModels.CurrencyApiResponse
import com.trinityjayd.biggerpicturenews.Models.CurrencyModels.ExchangeRateResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApi {
    @GET("v1/currencies")
    suspend fun getCurrencies(
        @Query("apikey") apiKey: String
    ): Response<CurrencyApiResponse>


    @GET("v1/latest")
    suspend fun getExchangeRates(
        @Query("apikey") apiKey: String,
        @Query("base_currency") baseCurrency: String,
        @Query("currencies") targetCurrency: String
    ): Response<ExchangeRateResponse>


}