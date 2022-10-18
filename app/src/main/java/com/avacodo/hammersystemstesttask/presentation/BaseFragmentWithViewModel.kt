package com.avacodo.hammersystemstesttask.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar

abstract class BaseFragmentWithViewModel<VB : ViewBinding, ResultType>(
    inflateBinding: (
        inflater: LayoutInflater,
        root: ViewGroup?,
        attachToRoot: Boolean,
    ) -> VB,
) : BaseFragment<VB>(inflateBinding) {

    abstract val viewModel: BaseViewModel<ResultType>

    protected open val progressBar: ProgressBar? = null

    protected open val provideOnStartLoadingAction = {
        progressBar?.isVisible = true
    }

    protected open val provideOnSuccessAction: (ResultType) -> Unit = {
        onEndLoading()
    }

    protected open val provideOnErrorAction: (String) -> Unit = { errorMessage ->
        onEndLoading()
        Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_SHORT).show()
    }

    private fun onEndLoading() {
        progressBar?.isVisible = false
    }
}