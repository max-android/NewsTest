package com.my_project.newstest.model.network

import com.my_project.newstest.ui.common.NetInspector
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response
import java.util.concurrent.TimeUnit

/**
 * Created Максим on 16.04.2019.
 * Copyright © Max
 */
class OfflineCacheInterceptor(private val netInspector:NetInspector):Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        if (!netInspector.isOnline()) {
            val cacheControl = CacheControl.Builder()
                .maxStale(1, TimeUnit.DAYS)
                .build()
            request = request.newBuilder()
                .header("Cache-Control", cacheControl.toString())
                .build()
        }
        return chain.proceed(request)
    }
}