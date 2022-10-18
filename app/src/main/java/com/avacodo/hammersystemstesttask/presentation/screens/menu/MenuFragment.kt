package com.avacodo.hammersystemstesttask.presentation.screens.menu

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.avacodo.hammersystemstesttask.BaseFragment
import com.avacodo.hammersystemstesttask.databinding.FragmentMenuBinding
import com.avacodo.hammersystemstesttask.domain.models.ToolbarBannerDomain
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.stateViewModel

class MenuFragment : BaseFragment<FragmentMenuBinding, String>(FragmentMenuBinding::inflate) {

    private val viewModel by stateViewModel<MenuViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bannersList = mutableListOf<ToolbarBannerDomain>()
        repeat(3) {
            bannersList.add(ToolbarBannerDomain(
                id = it + 1,
                imageSource = "https://i.ibb.co/ZWyVqdL/Hammer-Systems-Banner-Example.png"
            ))
        }

        val bannersAdapter = ToolbarBannersAdapter()

        binding.toolbarBannersRecyclerView.adapter = bannersAdapter

        bannersAdapter.setData(bannersList)

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.getProducts()
        }
    }
}