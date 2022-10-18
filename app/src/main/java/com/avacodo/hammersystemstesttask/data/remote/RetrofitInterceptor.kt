package com.avacodo.hammersystemstesttask.data.remote

import okhttp3.Interceptor
import okhttp3.Response

private const val CATEGORY_ID_PARAM_NAME = "categoryId"
private const val FIAS_ID_PARAM_NAME = "fiasId"
private const val CATEGORY_ID_VALUE = "5dfcb0c4ac65eaba25f77843"
private const val FIAS_ID_VALUE = "0c5b2444-70a0-4932-980c-b4dc0d3f02b5"

class RetrofitInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val updatedUrl = chain.request().url.newBuilder()
            .addQueryParameter(CATEGORY_ID_PARAM_NAME, CATEGORY_ID_VALUE)
            .addQueryParameter(FIAS_ID_PARAM_NAME, FIAS_ID_VALUE)
            .build()

        return chain.proceed(
            chain.request().newBuilder()
                .url(updatedUrl)
                .build()
        )
    }
}