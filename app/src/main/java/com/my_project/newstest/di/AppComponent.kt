package com.my_project.newstest.di

import com.my_project.newstest.presentation.detail.DetailPresenter
import com.my_project.newstest.presentation.main.MainPresenter
import com.my_project.newstest.presentation.news.NewsPresenter
import com.my_project.newstest.ui.detail.DetailFragment
import com.my_project.newstest.ui.main.MainActivity
import com.my_project.newstest.ui.news.NewsFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created Максим on 16.04.2019.
 * Copyright © Max
 */
@Singleton
@Component(
    modules = [
        RouterModule::class,
        NetworkModule::class,
        RepositoryModule::class
    ]
)

interface AppComponent {
    fun injectMainActivity(mainActivity: MainActivity)
    fun injectNewsFragment(newsFragment: NewsFragment)
    fun injectDetailFragment(detailFragment: DetailFragment)
    fun injectMainPresenter(mainPresenter: MainPresenter)
    fun injectNewsPresenter(newsPresenter: NewsPresenter)
    fun injectDetailPresenter(detailPresenter: DetailPresenter)
}