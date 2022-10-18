package com.avacodo.hammersystemstesttask.domain.usecase

import com.avacodo.hammersystemstesttask.domain.models.ToolbarBannerDomain

interface GetToolbarsBannersUsecase {
    suspend fun getBanners(): List<ToolbarBannerDomain>
}