package com.avacodo.hammersystemstesttask.presentation.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.avacodo.hammersystemstesttask.R
import com.avacodo.hammersystemstesttask.presentation.mainactivity.NavigationRouterProvider
import com.avacodo.hammersystemstesttask.presentation.screens.navigation.NavigationRouter

abstract class BaseFragment<VB : ViewBinding>(
    private val inflateBinding: (
        inflater: LayoutInflater,
        root: ViewGroup?,
        attachToRoot: Boolean,
    ) -> VB,
) : Fragment() {

    private var _binding: VB? = null
    val binding: VB get() = _binding!!

    protected lateinit var router: NavigationRouter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = inflateBinding.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (requireActivity() !is NavigationRouterProvider) {
            throw IllegalStateException(getString(
                R.string.activity_isnt_navigation_router_provider_error_msg))
        } else {
            router = (requireActivity() as NavigationRouterProvider).provideNavigationRouter()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}