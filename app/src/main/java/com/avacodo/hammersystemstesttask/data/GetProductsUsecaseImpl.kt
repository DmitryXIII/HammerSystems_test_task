package com.avacodo.hammersystemstesttask.data

import com.avacodo.hammersystemstesttask.domain.models.ProductDomain
import com.avacodo.hammersystemstesttask.domain.usecase.GetProductsUsecase

class GetProductsUsecaseImpl(private val repository: ProductsRepository) : GetProductsUsecase {
    override suspend fun getProducts(isCashDataRequired: Boolean): List<ProductDomain> {
        return if (isCashDataRequired) {
            repository.getLocalProducts()
        } else {
            repository.getRemoteProducts()
        }
    }
}