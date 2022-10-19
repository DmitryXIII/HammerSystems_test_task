package com.avacodo.hammersystemstesttask.data

import com.avacodo.hammersystemstesttask.data.local.entity.BannersLocalEntity
import com.avacodo.hammersystemstesttask.data.local.entity.ProductsLocalEntity
import com.avacodo.hammersystemstesttask.data.remote.dto.ProductDto
import com.avacodo.hammersystemstesttask.domain.models.ProductDomain
import com.avacodo.hammersystemstesttask.domain.models.ToolbarBannerDomain

class ModelsMapper {
    fun mapRemoteDtoToDomain(productDto: ProductDto): ProductDomain {
        return with(productDto) {
            ProductDomain(
                id = id,
                name = name,
                description = detailText,
                price = offers.first().price.toInt(),
                imageUrl = offers.first().previewPicture
            )
        }
    }

    fun mapProductDomainToLocal(productDomain: ProductDomain): ProductsLocalEntity {
        return with(productDomain) {
            ProductsLocalEntity(
                id = id,
                name = name,
                description = description,
                price = price,
                imageUrl = imageUrl
            )
        }
    }

    fun mapBannerDomainToLocal(bannerDomain: ToolbarBannerDomain): BannersLocalEntity {
        return with(bannerDomain) {
            BannersLocalEntity(
                id = id,
                imageUrl = imageUrl
            )
        }
    }
}