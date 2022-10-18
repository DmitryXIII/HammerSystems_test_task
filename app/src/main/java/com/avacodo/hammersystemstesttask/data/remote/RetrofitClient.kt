package com.avacodo.hammersystemstesttask.data.remote

import com.avacodo.hammersystemstesttask.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class RetrofitClient {
    fun createClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
            .addInterceptor(RetrofitInterceptor())

        if (BuildConfig.DEBUG) {
            client.addInterceptor(HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY))
        }

        return client.build()
    }
}