package com.avacodo.hammersystemstesttask.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class BannersLocalEntity(
    @PrimaryKey
    val id: Int,
    val imageUrl: String
)