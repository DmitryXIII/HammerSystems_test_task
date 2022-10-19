package com.avacodo.hammersystemstesttask.presentation.screens.navigation

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.avacodo.hammersystemstesttask.R
import com.avacodo.hammersystemstesttask.databinding.FragmentNavigationBinding
import com.avacodo.hammersystemstesttask.presentation.core.BaseFragment
import com.avacodo.hammersystemstesttask.presentation.screens.menu.MenuFragment

class NavigationFragment :
    BaseFragment<FragmentNavigationBinding>(FragmentNavigationBinding::inflate), NavigationRouter {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null) {
            router.navigateToDestination(MenuFragment())
        }

        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_navigate_to_menu -> {
                    navigateToNavigationViewAction(menuItem, MenuFragment())
                    true
                }

                R.id.action_navigate_to_profile -> {
                    Toast.makeText(requireContext(), "Экран \"Профиль\"", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.action_navigate_to_basket -> {
                    Toast.makeText(requireContext(), "Экран \"Корзина\"", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> true
            }
        }
    }

    override fun navigateToDestination(destination: Fragment) {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.navigation_container, destination)
            .commit()
    }

    override fun navigateToNavigationViewAction(menuItem: MenuItem, destination: Fragment) {
        if (binding.bottomNavigationView.selectedItemId != menuItem.itemId) {
            navigateToDestination(destination)
        }
    }
}