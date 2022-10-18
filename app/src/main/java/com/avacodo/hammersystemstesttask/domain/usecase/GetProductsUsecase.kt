package com.avacodo.hammersystemstesttask.domain.usecase

import com.avacodo.hammersystemstesttask.domain.models.MenuDataDomain

interface GetProductsUsecase {
    suspend fun getMenuData(isCashDataRequired: Boolean): MenuDataDomain
}