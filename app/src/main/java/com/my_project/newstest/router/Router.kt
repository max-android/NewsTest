package com.my_project.newstest.router

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.my_project.newstest.R
import com.my_project.newstest.model.entity.Headline
import com.my_project.newstest.ui.detail.DetailFragment
import com.my_project.newstest.ui.news.NewsFragment

/**
 * Created Максим on 16.04.2019.
 * Copyright © Max
 */
class Router {

    lateinit var screen: String

    fun createFragment(fragmentManager: FragmentManager, screenKey: String,data:Any) = when (screenKey) {

        Screens.NEWS_FRAGMENT -> {
            screen = screenKey
            replaceScreen(fragmentManager, NewsFragment.newInstance(), false)
        }

        Screens.DETAIL_FRAGMENT -> {
            screen = screenKey
            replaceScreen(fragmentManager,DetailFragment.newInstance(data as Headline), true)
        }

        else -> throw Exception("unknown case")
    }

    fun back(fragmentManager: FragmentManager){
        fragmentManager.popBackStack()
    }

    fun replaceScreen(fragmentManager: FragmentManager, fragment: Fragment, addToBackStack: Boolean) {
        fragmentManager.beginTransaction()
            .replace(R.id.main_container, fragment)
            .apply { if (addToBackStack) addToBackStack(null) }
            .setCustomAnimations(R.animator.slide_in_right, R.animator.slide_out_left, R.animator.slide_in_left, R.animator.slide_out_right)
            .commitAllowingStateLoss()
    }

    fun launchWebScreen(context: Context,intent: Intent){
        context.startActivity(intent)
    }
}