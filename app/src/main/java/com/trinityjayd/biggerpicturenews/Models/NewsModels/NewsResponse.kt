package com.trinityjayd.biggerpicturenews.Models.NewsModels

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)
