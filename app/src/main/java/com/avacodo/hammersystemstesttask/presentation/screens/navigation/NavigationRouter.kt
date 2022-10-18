package com.avacodo.hammersystemstesttask.presentation.screens.navigation

import android.view.MenuItem
import androidx.fragment.app.Fragment

interface NavigationRouter {
    fun navigateToDestination(destination: Fragment)
    fun navigateToNavigationViewAction(menuItem: MenuItem, destination: Fragment)
}