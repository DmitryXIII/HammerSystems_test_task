package com.avacodo.hammersystemstesttask.presentation.screens.menu

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.avacodo.hammersystemstesttask.databinding.FragmentMenuBinding
import com.avacodo.hammersystemstesttask.domain.models.MenuDataDomain
import com.avacodo.hammersystemstesttask.presentation.core.BaseFragmentWithViewModel
import org.koin.androidx.viewmodel.ext.android.stateViewModel

class MenuFragment :
    BaseFragmentWithViewModel<FragmentMenuBinding, MenuDataDomain>(FragmentMenuBinding::inflate) {

    override val viewModel by stateViewModel<MenuViewModel>()
    private val bannersAdapter = ToolbarBannersAdapter()
    private val productsAdapter = ProductsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        restoreTabPosition()
        initAdapters()
        subscribeOnDataChanges()

        if (savedInstanceState == null) {
            viewModel.getMenuData(isNetworkConnectionDisabled)
        }
    }

    private fun subscribeOnDataChanges() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.getData().collect {
                it?.handleState(
                    onStartLoadingAction = provideOnStartLoadingAction,
                    onSuccessAction = provideOnSuccessAction,
                    onErrorAction = provideOnErrorAction
                )
            }
        }
    }

    private fun initAdapters() {
        binding.toolbarBannersRecyclerView.adapter = bannersAdapter
        binding.menuProductsRecyclerView.adapter = productsAdapter
    }

    private fun restoreTabPosition() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.getSavedTabPosition().collect {
                binding.tabLayout.root.getTabAt(it)?.select()
            }
        }
    }

    override val provideOnSuccessAction: (MenuDataDomain) -> Unit = {
        super.provideOnSuccessAction
        bannersAdapter.setData(it.banners)
        productsAdapter.setData(it.products)
    }

    override fun onDestroy() {
        viewModel.saveTabPosition(binding.tabLayout.root.selectedTabPosition)
        super.onDestroy()
    }
}