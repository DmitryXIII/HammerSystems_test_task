package com.avacodo.hammersystemstesttask.presentation.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.avacodo.hammersystemstesttask.presentation.network.ConnectionHandler
import com.avacodo.hammersystemstesttask.presentation.network.ConnectivityObserver
import com.avacodo.hammersystemstesttask.presentation.network.NetworkConnectionStatus
import com.google.android.material.snackbar.Snackbar
import org.koin.android.ext.android.inject

abstract class BaseFragmentWithViewModel<VB : ViewBinding, ResultType>(
    inflateBinding: (
        inflater: LayoutInflater,
        root: ViewGroup?,
        attachToRoot: Boolean,
    ) -> VB,
) : BaseFragment<VB>(inflateBinding) {

    private val networkStatusHandler: ConnectionHandler by inject()
    private val connectivityManager: ConnectivityObserver by inject()
    protected var isNetworkConnectionDisabled = false

    abstract val viewModel: BaseViewModel<ResultType>

    protected open val progressBar: ProgressBar? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!connectivityManager.checkIfNetworkAvailable()) {
            networkStatusHandler.showNoConnectionAlert(requireActivity())
            isNetworkConnectionDisabled = true
        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            connectivityManager.observe().collect {
                if(it == NetworkConnectionStatus.AVAILABLE) {
                    isNetworkConnectionDisabled = false
                }
                networkStatusHandler.handleInternetConnectionStatus(requireActivity(), it)
            }
        }
    }

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