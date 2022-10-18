package com.avacodo.hammersystemstesttask.presentation.screens.menu

import androidx.lifecycle.SavedStateHandle
import com.avacodo.hammersystemstesttask.domain.models.MenuDataDomain
import com.avacodo.hammersystemstesttask.domain.usecase.GetProductsUsecase
import com.avacodo.hammersystemstesttask.presentation.AppState
import com.avacodo.hammersystemstesttask.presentation.BaseViewModel
import kotlinx.coroutines.flow.StateFlow

class MenuViewModel(
    private val usecase: GetProductsUsecase,
    stateHandle: SavedStateHandle,
) : BaseViewModel<MenuDataDomain>() {

    suspend fun getMenuData(): StateFlow<AppState<MenuDataDomain>?> {
        resultState.value = AppState.Loading()
        resultState.value = AppState.Success(usecase.getMenuData(false))
        return resultState
    }
}