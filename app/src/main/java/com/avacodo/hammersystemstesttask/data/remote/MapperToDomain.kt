package com.avacodo.hammersystemstesttask.data.remote

import com.avacodo.hammersystemstesttask.data.remote.dto.ProductDto
import com.avacodo.hammersystemstesttask.domain.models.ProductDomain

class MapperToDomain {
    fun mapRemoteDtoToDomain(productDto: ProductDto): ProductDomain {
        return ProductDomain(
            id = productDto.id,
            name = productDto.name,
            description = productDto.detailText,
            price = productDto.offers.first().price
        )
    }
}