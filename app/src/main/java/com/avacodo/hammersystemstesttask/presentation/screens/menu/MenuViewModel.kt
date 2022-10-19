package com.avacodo.hammersystemstesttask.presentation.screens.menu

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.avacodo.hammersystemstesttask.domain.models.MenuDataDomain
import com.avacodo.hammersystemstesttask.domain.usecase.GetProductsUsecase
import com.avacodo.hammersystemstesttask.presentation.AppState
import com.avacodo.hammersystemstesttask.presentation.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MenuViewModel(
    private val usecase: GetProductsUsecase,
    stateHandle: SavedStateHandle,
) : BaseViewModel<MenuDataDomain>() {

    fun getMenuData() {
        resultState.value = AppState.Loading()
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            resultState.value = AppState.Success(usecase.getMenuData(false))
        }
    }
}