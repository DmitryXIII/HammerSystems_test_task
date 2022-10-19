package com.avacodo.hammersystemstesttask.presentation.network

import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver {
    fun checkIfNetworkAvailable(): Boolean
    fun observe(): Flow<NetworkConnectionStatus>
}