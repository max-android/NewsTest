package com.my_project.newstest.presentation.detail

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

/**
 * Created Максим on 16.04.2019.
 * Copyright © Max
 */
@StateStrategyType(AddToEndSingleStrategy::class)
interface DetailView:MvpView {
    fun showWebVersion(url:String)
}