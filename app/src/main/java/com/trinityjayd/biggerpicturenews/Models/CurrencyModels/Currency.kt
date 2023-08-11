package com.trinityjayd.biggerpicturenews.Models.CurrencyModels

import com.beust.klaxon.Json

data class Currency (
    val symbol: String,
    val name: String,

    @Json(name = "symbol_native")
    val symbolNative: String,

    @Json(name = "decimal_digits")
    val decimalDigits: Long,

    val rounding: Long,
    val code: String,

    @Json(name = "name_plural")
    val namePlural: String
)