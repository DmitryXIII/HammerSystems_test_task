package com.avacodo.hammersystemstesttask.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class ProductsLocalEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val description: String,
    val price: Int,
    val imageUrl: String
)