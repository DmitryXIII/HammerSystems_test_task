package com.avacodo.hammersystemstesttask.domain.usecase

import com.avacodo.hammersystemstesttask.domain.models.ProductDomain

interface GetProductsUsecase {
    suspend fun getProducts(isNetworkActive: Boolean): List<ProductDomain>
}