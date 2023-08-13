package com.trinityjayd.biggerpicturenews.Models.NewsModels

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Source(
    val id: String?,
    val name: String
): Parcelable
