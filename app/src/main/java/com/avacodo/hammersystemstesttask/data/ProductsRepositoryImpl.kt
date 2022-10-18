package com.avacodo.hammersystemstesttask.data

import com.avacodo.hammersystemstesttask.data.remote.ProductsApi
import com.avacodo.hammersystemstesttask.domain.models.ProductDomain

class ProductsRepositoryImpl(
    private val remoteDataSource: ProductsApi,
    private val mapperToDomain: MapperToDomain,
) : ProductsRepository {
    override suspend fun getRemoteProducts(): List<ProductDomain> {
        return remoteDataSource.getProductsAsync().await().products.map {
            mapperToDomain.mapRemoteDtoToDomain(it)
        }
    }

    override suspend fun getLocalProducts(): List<ProductDomain> {
        TODO("Not yet implemented")
    }
}