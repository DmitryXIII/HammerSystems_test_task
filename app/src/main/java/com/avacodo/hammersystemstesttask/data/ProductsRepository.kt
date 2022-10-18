package com.avacodo.hammersystemstesttask.data

import com.avacodo.hammersystemstesttask.domain.models.ProductDomain

interface ProductsRepository {
    suspend fun getRemoteProducts(): List<ProductDomain>
    suspend fun getLocalProducts(): List<ProductDomain>
}