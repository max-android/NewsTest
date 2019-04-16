package com.my_project.newstest.di

import com.my_project.newstest.router.Router
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created Максим on 16.04.2019.
 * Copyright © Max
 */
@Module
class RouterModule {

    @Provides
    @Singleton
    fun provideRouter(): Router = Router()
}