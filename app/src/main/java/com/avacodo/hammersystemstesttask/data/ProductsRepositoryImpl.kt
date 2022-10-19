package com.avacodo.hammersystemstesttask.data

import com.avacodo.hammersystemstesttask.data.local.CashDao
import com.avacodo.hammersystemstesttask.data.remote.ProductsApi
import com.avacodo.hammersystemstesttask.domain.models.MenuDataDomain
import com.avacodo.hammersystemstesttask.domain.models.ProductDomain
import com.avacodo.hammersystemstesttask.domain.models.ToolbarBannerDomain

private const val FAKE_BANNERS_URL = "https://i.ibb.co/ZWyVqdL/Hammer-Systems-Banner-Example.png"

class ProductsRepositoryImpl(
    private val remoteDataSource: ProductsApi,
    private val localDataSource: CashDao,
    private val modelsMapper: ModelsMapper,
) : ProductsRepository {
    override suspend fun getRemoteProducts(): List<ProductDomain> {
        return remoteDataSource.getProductsAsync().await().products.map {
            modelsMapper.mapRemoteDtoToDomain(it)
        }
    }

    override suspend fun getLocalProducts(): List<ProductDomain> {
        return localDataSource.getProductsCash().map { modelsMapper.mapProductLocalToDomain(it) }
    }

    override suspend fun getLocalBanners(): List<ToolbarBannerDomain> {
        return localDataSource.getBannersCash().map { modelsMapper.mapBannerLocalToDomain(it) }
    }

    override suspend fun getRemoteBanners(): List<ToolbarBannerDomain> {
        val fakeBannersList = mutableListOf<ToolbarBannerDomain>()
        repeat(3) {
            fakeBannersList.add(ToolbarBannerDomain(
                id = it + 1,
                imageUrl = FAKE_BANNERS_URL
            ))
        }
        return fakeBannersList
    }

    override suspend fun saveToCash(dataList: MenuDataDomain) {
        localDataSource.apply {
            clearProductsCash()
            clearBannersCash()
            saveProductsToCash(dataList.products.map { modelsMapper.mapProductDomainToLocal(it) })
            saveBannersToCash(dataList.banners.map { modelsMapper.mapBannerDomainToLocal(it) })
        }
    }
}