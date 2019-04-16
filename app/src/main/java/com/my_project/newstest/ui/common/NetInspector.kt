package com.my_project.newstest.ui.common

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 * Created Максим on 16.04.2019.
 * Copyright © Max
 */
class NetInspector(private val context: Context) {

    fun isOnline(): Boolean {
        var isConnected: Boolean = false // Initial Value
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        if (activeNetwork != null && activeNetwork.isConnected)
            isConnected = true
        return isConnected
    }
}

