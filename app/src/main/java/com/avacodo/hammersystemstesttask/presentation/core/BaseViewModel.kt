package com.avacodo.hammersystemstesttask.presentation.core

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel<ResultType> : ViewModel() {
    protected val resultState = MutableStateFlow<AppState<ResultType>?>(null)

    protected val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        resultState.value = AppState.Error(throwable.message.toString())
    }

    fun getData(): StateFlow<AppState<ResultType>?> = resultState.asStateFlow()
}