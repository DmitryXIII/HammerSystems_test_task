package com.avacodo.hammersystemstesttask.data

import com.avacodo.hammersystemstesttask.domain.models.ProductDomain
import com.avacodo.hammersystemstesttask.domain.models.ToolbarBannerDomain

interface ProductsRepository {
    suspend fun getRemoteProducts(): List<ProductDomain>
    suspend fun getLocalProducts(): List<ProductDomain>
    suspend fun getLocalBanners(): List<ToolbarBannerDomain>
    suspend fun getRemoteBanners(): List<ToolbarBannerDomain>
}