package com.trinityjayd.biggerpicturenews.Models.WeatherModels

import com.beust.klaxon.Json

data class Imperial (
    @Json(name = "Value")
    val Value: Long,

    @Json(name = "Unit")
    val unit: String,

    @Json(name = "UnitType")
    val unitType: Long
)