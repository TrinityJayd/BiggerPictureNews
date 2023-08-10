package com.trinityjayd.biggerpicturenews.Models.WeatherModels

import com.beust.klaxon.Json

data class Temperature(
    @Json(name = "Metric")
    val Metric: Metric,

    @Json(name = "Imperial")
    val Imperial: Imperial
)