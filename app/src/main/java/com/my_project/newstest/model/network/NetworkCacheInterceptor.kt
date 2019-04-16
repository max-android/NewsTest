package com.my_project.newstest.model.network

import android.util.Log
import com.my_project.newstest.ui.common.CONST.MAX_AGE
import com.my_project.newstest.ui.common.CONST.MAX_STALE
import com.my_project.newstest.ui.common.NetInspector
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created Максим on 16.04.2019.
 * Copyright © Max
 */
class NetworkCacheInterceptor(private val netInspector: NetInspector) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        Log.d("MY_LOG", "NetworkCacheInterceptor")

        val cacheHeaderValue = if (netInspector.isOnline()) "public, max-age=$MAX_AGE"
        else "public, only-if-cached, max-stale=$MAX_STALE"

        val request = originalRequest.newBuilder().build()
        val response = chain.proceed(request)
        return response.newBuilder()
            .removeHeader("Pragma")
            .removeHeader("Cache-Control")
            .header("Cache-Control", cacheHeaderValue)
            .build()
    }
}