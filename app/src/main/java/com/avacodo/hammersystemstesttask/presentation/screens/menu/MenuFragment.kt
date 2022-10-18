package com.avacodo.hammersystemstesttask.presentation.screens.menu

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.avacodo.hammersystemstesttask.databinding.FragmentMenuBinding
import com.avacodo.hammersystemstesttask.domain.models.MenuDataDomain
import com.avacodo.hammersystemstesttask.presentation.BaseFragment
import org.koin.androidx.viewmodel.ext.android.stateViewModel

class MenuFragment :
    BaseFragment<FragmentMenuBinding, MenuDataDomain>(FragmentMenuBinding::inflate) {

    private val viewModel by stateViewModel<MenuViewModel>()
    private val bannersAdapter = ToolbarBannersAdapter()
    private val productsAdapter = ProductsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbarBannersRecyclerView.adapter = bannersAdapter
        binding.menuProductsRecyclerView.adapter = productsAdapter

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.getMenuData().collect {
                it?.handleState(
                    onStartLoadingAction = provideOnStartLoadingAction,
                    onSuccessAction = provideOnSuccessAction,
                    onErrorAction = provideOnErrorAction
                )
            }
        }
    }

    override val provideOnSuccessAction: (MenuDataDomain) -> Unit = {
        super.provideOnSuccessAction
        Log.d("@#@", "${it.products}")
        bannersAdapter.setData(it.banners)
        productsAdapter.setData(it.products)
    }
}