package com.my_project.newstest.presentation.news

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.my_project.newstest.model.entity.Headline

/**
 * Created Максим on 16.04.2019.
 * Copyright © Max
 */
@StateStrategyType(AddToEndSingleStrategy::class)
interface NewsView:MvpView {
    fun showNews(news:List<Headline>)
    @StateStrategyType(SkipStrategy::class)
    fun showError(message:String)
    @StateStrategyType(SkipStrategy::class)
    fun showProgress()
    @StateStrategyType(SkipStrategy::class)
    fun removeProgress()
    @StateStrategyType(SkipStrategy::class)
    fun showHeadline(headline: Headline)
}