package com.trinityjayd.biggerpicturenews.Models.WeatherModels

import com.beust.klaxon.*

data class Weather(
    @Json(name = "LocalObservationDateTime")
    val localObservationDateTime: String,

    @Json(name = "EpochTime")
    val epochTime: Long,

    @Json(name = "WeatherText")
    val WeatherText: String,

    @Json(name = "WeatherIcon")
    val weatherIcon: Long,

    @Json(name = "HasPrecipitation")
    val hasPrecipitation: Boolean,

    @Json(name = "PrecipitationType")
    val precipitationType: Any? = null,

    @Json(name = "IsDayTime")
    val isDayTime: Boolean,

    @Json(name = "Temperature")
    val Temperature: Temperature,

    @Json(name = "MobileLink")
    val mobileLink: String,

    @Json(name = "Link")
    val link: String
)
