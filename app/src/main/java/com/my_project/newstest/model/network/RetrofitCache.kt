package com.my_project.newstest.model.network

import android.content.Context
import okhttp3.Cache
import java.io.File

/**
 * Created Максим on 16.04.2019.
 * Copyright © Max
 */
class RetrofitCache(private val context: Context) {

    fun cache():Cache?{
        var cache: Cache? = null
        try {
            val dir = context.cacheDir
            cache = Cache(File(dir, "http-cache"), (10 * 1024 * 1024).toLong()) // 10 MB
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return cache
    }

}