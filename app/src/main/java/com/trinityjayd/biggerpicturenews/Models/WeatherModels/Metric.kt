package com.trinityjayd.biggerpicturenews.Models.WeatherModels

import com.beust.klaxon.Json

data class Metric (
    @Json(name = "Value")
    val Value: Double,

    @Json(name = "Unit")
    val unit: String,

    @Json(name = "UnitType")
    val unitType: Long
)