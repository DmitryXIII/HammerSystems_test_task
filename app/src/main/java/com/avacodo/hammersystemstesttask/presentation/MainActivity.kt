package com.avacodo.hammersystemstesttask.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.avacodo.hammersystemstesttask.R
import com.avacodo.hammersystemstesttask.presentation.screens.menu.MenuFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, MenuFragment())
                .commit()
        }
    }
}