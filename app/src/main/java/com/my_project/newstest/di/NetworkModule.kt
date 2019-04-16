package com.my_project.newstest.di

import android.content.Context
import com.my_project.newstest.model.network.ApiService
import com.my_project.newstest.model.network.NetworkCacheInterceptor
import com.my_project.newstest.model.network.OfflineCacheInterceptor
import com.my_project.newstest.model.network.RetrofitCache
import com.my_project.newstest.ui.common.CONST
import com.my_project.newstest.ui.common.NetInspector
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created Максим on 16.04.2019.
 * Copyright © Max
 */
@Module
class NetworkModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideNetInspector()= NetInspector(context)

    @Provides
    @Singleton
    fun provideRetrofitCache() = RetrofitCache(context)

    @Provides
    @Singleton
    fun provideOfflineCacheInterceptor(netInspector :NetInspector) = OfflineCacheInterceptor(netInspector)

    @Provides
    @Singleton
    fun provideNetworkCacheInterceptor(netInspector :NetInspector) = NetworkCacheInterceptor(netInspector)

    @Provides
    @Singleton
    fun provideOkHttpClient(netInspector :NetInspector): OkHttpClient =
        OkHttpClient.Builder()
            .cache(provideRetrofitCache().cache())
            .addInterceptor(provideOfflineCacheInterceptor(netInspector))
            .addNetworkInterceptor(provideNetworkCacheInterceptor(netInspector))
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(CONST.BASE_URL)
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(
        ApiService::class.java)
}