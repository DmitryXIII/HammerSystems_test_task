package com.avacodo.hammersystemstesttask.data.remote.dto


import com.google.gson.annotations.SerializedName

data class ProductDto(
    @SerializedName("categoryName")
    val categoryName: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("detailText")
    val detailText: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("mcId")
    val mcId: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("offers")
    val offers: List<OfferDto>,
    @SerializedName("size")
    val size: String,
    @SerializedName("sorting")
    val sorting: Int,
    @SerializedName("subSubcatId")
    val subSubcatId: Any?,
    @SerializedName("subcatId")
    val subcatId: String
)