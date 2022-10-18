package com.avacodo.hammersystemstesttask.presentation.screens.menu

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.avacodo.hammersystemstesttask.domain.usecase.GetProductsUsecase

class MenuViewModel(
    private val usecase: GetProductsUsecase,
    stateHandle: SavedStateHandle,
) : ViewModel() {
    suspend fun getProducts() {
        usecase.getProducts(false)
    }
}