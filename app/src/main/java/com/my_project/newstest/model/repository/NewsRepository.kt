package com.my_project.newstest.model.repository

import com.my_project.newstest.model.entity.Headline
import com.my_project.newstest.model.network.ApiService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created Максим on 16.04.2019.
 * Copyright © Max
 */
class NewsRepository  @Inject constructor(private val apiService: ApiService)  {

    fun news():Single<List<Headline>> = apiService.newsRequest()
       .map { it.news }
       .subscribeOn(Schedulers.io())
       .observeOn(AndroidSchedulers.mainThread())

    fun search(search:String):Single<List<Headline>> = apiService.searchRequest(search)
        .map { it.news }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}