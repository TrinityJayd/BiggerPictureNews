package com.trinityjayd.biggerpicturenews.Apis

import com.trinityjayd.biggerpicturenews.Models.NewsModels.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("top-headlines")
    suspend fun getNews(
        @Query("apikey") apiKey: String,
        @Query("sources") sources : String
    ): Response<NewsResponse>


}