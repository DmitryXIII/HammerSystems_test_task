package com.avacodo.hammersystemstesttask.data.remote.dto


import com.google.gson.annotations.SerializedName

data class ProductResponseDto(
    @SerializedName("products")
    val products: List<ProductDto>,
)