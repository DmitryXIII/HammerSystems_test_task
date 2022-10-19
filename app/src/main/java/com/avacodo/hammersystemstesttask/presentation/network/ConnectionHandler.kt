package com.avacodo.hammersystemstesttask.presentation.network

import android.app.Activity

interface ConnectionHandler {
    fun handleInternetConnectionStatus(activity: Activity, status: NetworkConnectionStatus)
    fun showNoConnectionAlert(activity: Activity)
}