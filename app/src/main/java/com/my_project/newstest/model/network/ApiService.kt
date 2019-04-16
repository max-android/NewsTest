package com.my_project.newstest.model.network

import com.my_project.newstest.model.entity.News
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created Максим on 16.04.2019.
 * Copyright © Max
 */
interface ApiService {

    @GET("v2/top-headlines?country=ru&apiKey=5ed19a44590c4e33a707249ee373b86d")
    fun newsRequest(): Single<News>

    @GET("v2/everything??&apiKey=5ed19a44590c4e33a707249ee373b86d")
    fun searchRequest(@Query("q")search: String): Single<News>

}