package com.my_project.newstest

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.my_project.newstest.App.Companion.appComponent
import com.my_project.newstest.di.*

/**
 * Created Максим on 16.04.2019.
 * Copyright © Max
 */
class App : Application() {

    companion object {
        @JvmStatic
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .networkModule(NetworkModule(this))
            .repositoryModule(RepositoryModule())
            .routerModule(RouterModule())
            .build()

        initFresco()
    }

    private fun initFresco() = Fresco.initialize(this)

}