package com.my_project.newstest.presentation.main

import android.content.Context
import android.content.Intent
import android.support.v4.app.FragmentManager
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.my_project.newstest.App
import com.my_project.newstest.router.Router
import javax.inject.Inject

/**
 * Created Максим on 16.04.2019.
 * Copyright © Max
 */
@InjectViewState
class MainPresenter: MvpPresenter<MainView>() {

    @Inject
    lateinit var router: Router

    init {
        App.appComponent.injectMainPresenter(this)
    }

    fun showScreen(fragmentManager: FragmentManager, screen: String,any:Any) {
        router.createFragment(fragmentManager, screen,any)
    }

    fun back(fragmentManager: FragmentManager){
        router.back(fragmentManager)
    }

    fun showLink(context:Context,intent:Intent){
        router.launchWebScreen(context,intent)
    }
}