package com.avacodo.hammersystemstesttask.data

import com.avacodo.hammersystemstesttask.data.remote.ProductsApi
import com.avacodo.hammersystemstesttask.domain.models.ProductDomain
import com.avacodo.hammersystemstesttask.domain.models.ToolbarBannerDomain

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

    override suspend fun getLocalBanners(): List<ToolbarBannerDomain> {
        TODO("Not yet implemented")
    }

    override suspend fun getRemoteBanners(): List<ToolbarBannerDomain> {
        val bannersList = mutableListOf<ToolbarBannerDomain>()
        repeat(3) {
            bannersList.add(ToolbarBannerDomain(
                id = it + 1,
                imageSource = "https://i.ibb.co/ZWyVqdL/Hammer-Systems-Banner-Example.png"
            ))
        }
        return bannersList
    }
}