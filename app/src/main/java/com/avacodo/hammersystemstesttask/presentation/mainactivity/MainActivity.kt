package com.avacodo.hammersystemstesttask.presentation.mainactivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.avacodo.hammersystemstesttask.R
import com.avacodo.hammersystemstesttask.presentation.screens.navigation.NavigationFragment
import com.avacodo.hammersystemstesttask.presentation.screens.navigation.NavigationRouter

private const val NAVIGATION_FRAGMENT_TAG = "NAVIGATION_FRAGMENT"

class MainActivity : AppCompatActivity(), NavigationRouterProvider {

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, NavigationFragment(), NAVIGATION_FRAGMENT_TAG)
                .commit()
        }
    }

    override fun provideNavigationRouter(): NavigationRouter {
        return supportFragmentManager.findFragmentByTag(NAVIGATION_FRAGMENT_TAG) as NavigationRouter
    }
}