package com.avacodo

import android.app.Application
import com.avacodo.hammersystemstesttask.di.appModule
import com.avacodo.hammersystemstesttask.di.retrofitModule
import com.avacodo.hammersystemstesttask.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(
                appModule,
                viewModelModule,
                retrofitModule,
            )
        }
    }
}