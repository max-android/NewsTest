package com.my_project.newstest.di

import com.my_project.newstest.model.network.ApiService
import com.my_project.newstest.model.repository.NewsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created Максим on 16.04.2019.
 * Copyright © Max
 */
@Module
class RepositoryModule {

    @Provides
    @Singleton
     fun provideNewsRepository(apiService: ApiService) = NewsRepository(apiService)
}