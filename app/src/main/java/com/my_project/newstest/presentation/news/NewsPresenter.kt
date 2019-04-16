package com.my_project.newstest.presentation.news

import android.annotation.SuppressLint
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.my_project.newstest.App
import com.my_project.newstest.model.entity.Headline
import com.my_project.newstest.model.network.ServerStatus
import com.my_project.newstest.model.repository.NewsRepository
import io.reactivex.disposables.CompositeDisposable
import retrofit2.HttpException
import java.net.ConnectException
import java.net.UnknownHostException
import javax.inject.Inject

/**
 * Created Максим on 16.04.2019.
 * Copyright © Max
 */
@InjectViewState
class NewsPresenter : MvpPresenter<NewsView>() {

    @Inject
    lateinit var newsRepository: NewsRepository
    private val compositeDisposable = CompositeDisposable()

    init {
        App.appComponent.injectNewsPresenter(this)
    }

    @SuppressLint("CheckResult")
    fun news() {

        compositeDisposable.add(
            newsRepository.news()
                .doOnSubscribe { viewState.showProgress() }
                .doFinally { viewState.removeProgress() }
                .subscribe(
                    { viewState.showNews(it) },
                    { error -> handleError(error) }
                )
        )
    }

    fun onClickItem(headline: Headline) {
        viewState.showHeadline(headline)
    }

    fun search(search: String) {
        compositeDisposable.add(
            newsRepository
                .search(search)
                .doOnSubscribe { viewState.showProgress() }
                .doFinally { viewState.removeProgress() }
                .subscribe(
                    { viewState.showNews(it) },
                    { error -> handleError(error) }
                )
        )
    }

    private fun handleError(error: Throwable?) {
        run {
            if (error != null) {
                when (error) {
                    is ConnectException -> viewState.showError(error.message ?: "null")
                    is UnknownHostException -> viewState.showError(error.message ?: "null")
                    is HttpException -> ServerStatus.compareCode(error.code()).let {
                        when (it) {
                            ServerStatus.BAD_REQUEST -> viewState.showError(it.getDesk())
                            ServerStatus.FORBIDDEN -> viewState.showError(it.getDesk())
                            ServerStatus.UNAUTHORIZED -> viewState.showError(it.getDesk())
                            ServerStatus.TOO_MANY_REQUESTS -> viewState.showError(it.getDesk())
                            ServerStatus.NOT_FOUND -> viewState.showError(it.getDesk())
                            ServerStatus.INTERNAL_SERVER_ERROR -> viewState.showError(it.getDesk())
                            else -> viewState.showError(error.message ?: "неизвестная ошибка")
                        }
                    }
                    else -> viewState.showError(error.message ?: "неизвестная ошибка")
                }
            } else {
                viewState.showError("NullPointerException")
            }
        }
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }
}