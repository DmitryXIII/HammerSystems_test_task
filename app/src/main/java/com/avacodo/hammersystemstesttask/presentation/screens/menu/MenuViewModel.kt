package com.avacodo.hammersystemstesttask.presentation.screens.menu

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.avacodo.hammersystemstesttask.domain.models.MenuDataDomain
import com.avacodo.hammersystemstesttask.domain.usecase.GetProductsUsecase
import com.avacodo.hammersystemstesttask.presentation.core.AppState
import com.avacodo.hammersystemstesttask.presentation.core.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

private const val SELECTED_TAB_POSITION_KEY = "SELECTED_TAB_POSITION"
private const val INITIAL_TAB_POSITION = 0

class MenuViewModel(
    private val usecase: GetProductsUsecase,
    private val stateHandle: SavedStateHandle,
) : BaseViewModel<MenuDataDomain>() {

    private val savedTabPosition =
        stateHandle.getStateFlow(SELECTED_TAB_POSITION_KEY, INITIAL_TAB_POSITION)

    fun getSavedTabPosition(): StateFlow<Int> = savedTabPosition

    fun saveTabPosition(tabPosition: Int) {
        stateHandle[SELECTED_TAB_POSITION_KEY] = tabPosition
    }

    fun getMenuData(isNetworkConnectionDisabled: Boolean) {
        resultState.value = AppState.Loading()
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            resultState.value = AppState.Success(usecase.getMenuData(isNetworkConnectionDisabled))
        }
    }
}