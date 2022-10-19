package com.avacodo.hammersystemstesttask.presentation.mainactivity

import com.avacodo.hammersystemstesttask.presentation.screens.navigation.NavigationRouter

interface NavigationRouterProvider {
    fun provideNavigationRouter(): NavigationRouter
}