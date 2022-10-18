package com.avacodo.hammersystemstesttask.domain.models

data class ProductDomain(
    val id: String,
    val name: String,
    val description: String,
    val price: Int,
    val imageUrl: String
)