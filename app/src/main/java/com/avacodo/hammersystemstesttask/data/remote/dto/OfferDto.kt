package com.avacodo.hammersystemstesttask.data.remote.dto

import com.google.gson.annotations.SerializedName

data class OfferDto(
    @SerializedName("previewPicture")
    val previewPicture: String,
    @SerializedName("price")
    val price: Double,
)