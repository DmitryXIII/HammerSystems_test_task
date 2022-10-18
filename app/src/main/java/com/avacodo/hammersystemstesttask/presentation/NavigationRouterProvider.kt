package com.avacodo.hammersystemstesttask.presentation

import com.avacodo.hammersystemstesttask.presentation.screens.navigation.NavigationRouter

interface NavigationRouterProvider {
    fun provideNavigationRouter(): NavigationRouter
}