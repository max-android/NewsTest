package com.my_project.newstest.presentation.detail

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

/**
 * Created Максим on 16.04.2019.
 * Copyright © Max
 */
@InjectViewState
class DetailPresenter: MvpPresenter<DetailView>() {
    fun onLinkClick(url:String){
       viewState.showWebVersion(url)
    }
}