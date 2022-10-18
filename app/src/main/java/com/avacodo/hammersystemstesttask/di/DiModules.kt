package com.avacodo.hammersystemstesttask.di

import com.avacodo.hammersystemstesttask.data.GetProductsUsecaseImpl
import com.avacodo.hammersystemstesttask.data.MapperToDomain
import com.avacodo.hammersystemstesttask.data.ProductsRepository
import com.avacodo.hammersystemstesttask.data.ProductsRepositoryImpl
import com.avacodo.hammersystemstesttask.data.remote.ProductsApi
import com.avacodo.hammersystemstesttask.data.remote.RetrofitClient
import com.avacodo.hammersystemstesttask.domain.usecase.GetProductsUsecase
import com.avacodo.hammersystemstesttask.presentation.screens.menu.MenuViewModel
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://site-api.vkusnoitochka.ru/"

val appModule = module {
    single<GetProductsUsecase> { GetProductsUsecaseImpl(repository = get()) }

    single<ProductsRepository> {
        ProductsRepositoryImpl(
            remoteDataSource = get(),
            mapperToDomain = get())
    }

    single { MapperToDomain() }
}

val viewModelModule = module {
    viewModel { MenuViewModel(usecase = get(), stateHandle = get()) }
}

val retrofitModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient()
                .create()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(RetrofitClient().createClient())
            .build().create(ProductsApi::class.java)
    }
}
