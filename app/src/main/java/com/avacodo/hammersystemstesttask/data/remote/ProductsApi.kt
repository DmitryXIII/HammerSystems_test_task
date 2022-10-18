package com.avacodo.hammersystemstesttask.data.remote

import com.avacodo.hammersystemstesttask.data.remote.dto.ProductDto
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

private const val BASE_PATH = "catalog/category"

interface ProductsApi {
    @GET(BASE_PATH)
    fun getProductsAsync(): Deferred<List<ProductDto>>
}