package com.avacodo.hammersystemstesttask.data

import com.avacodo.hammersystemstesttask.domain.models.MenuDataDomain
import com.avacodo.hammersystemstesttask.domain.usecase.GetProductsUsecase

class GetProductsUsecaseImpl(private val repository: ProductsRepository) : GetProductsUsecase {
    override suspend fun getMenuData(isCashDataRequired: Boolean): MenuDataDomain {
        return if (isCashDataRequired) {
            MenuDataDomain(
                products = repository.getLocalProducts(),
                banners = repository.getLocalBanners()
            )
        } else {
            MenuDataDomain(
                products = repository.getRemoteProducts(),
                banners = repository.getRemoteBanners()
            )
        }
    }
}