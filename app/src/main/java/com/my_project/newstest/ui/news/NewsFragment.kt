package com.my_project.newstest.ui.news

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.my_project.newstest.R
import com.my_project.newstest.model.entity.Headline
import com.my_project.newstest.presentation.news.NewsPresenter
import com.my_project.newstest.presentation.news.NewsView
import com.my_project.newstest.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_news.*
import org.jetbrains.anko.design.longSnackbar
import org.jetbrains.anko.support.v4.longToast

/**
 * Created Максим on 16.04.2019.
 * Copyright © Max
 */
class NewsFragment : MvpAppCompatFragment(), NewsView {


    companion object {
        fun newInstance(): NewsFragment {
            return NewsFragment()
        }
    }

    @JvmField
    @InjectPresenter
    var newsPresenter: NewsPresenter? = null

    private lateinit var newsAdapter: NewsAdapter
    private var newsCallback: NewsCallback? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is NewsCallback) {
            newsCallback = context
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViews()
        if (savedInstanceState == null) showNews()
    }

    override fun onDetach() {
        super.onDetach()
        newsCallback = null
    }

    override fun showNews(news: List<Headline>) {
        if (news.isEmpty()) {
            newsAdapter.clear()
            longSnackbar(searchEditText, context!!.resources.getString(R.string.cant_load_data))
        } else {
            newsAdapter.setData(news)
        }
    }

    override fun showError(message: String) {
        longToast(message)
    }

    override fun showProgress() {
        newsProgressBar.visibility = View.VISIBLE
    }

    override fun removeProgress() {
        newsProgressBar.visibility = View.GONE
    }

    override fun showHeadline(headline: Headline) {
        newsCallback?.newsClick(headline)
    }

    private fun initViews() {

        val actionBar = (activity as MainActivity).actionBar
        actionBar?.title = context?.resources?.getString(R.string.news)
        actionBar?.setDisplayHomeAsUpEnabled(false)

        swipeRefreshLayout.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE, Color.CYAN)
        swipeRefreshLayout.setOnRefreshListener { refreshScreen() }
        newsAdapter = NewsAdapter {
            newsPresenter?.onClickItem(it)
        }
        newsRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@NewsFragment.context, LinearLayoutManager.VERTICAL, false)
            addItemDecoration(DividerItemDecoration(this@NewsFragment.context, LinearLayout.VERTICAL))
            adapter = newsAdapter
        }
        searchButton.setOnClickListener { searchNews() }
    }

    private fun showNews() {
        newsPresenter?.news()
    }

    private fun refreshScreen() {
        swipeRefreshLayout.isRefreshing = true
        searchEditText.text = null
        showNews()
        swipeRefreshLayout.isRefreshing = false
    }

    private fun searchNews() {
        if (validateForm()) newsPresenter?.search(searchEditText.text.toString())
        else longSnackbar(searchEditText, context!!.resources.getString(R.string.fill_in_the_fields))
    }

    private fun validateForm(): Boolean {
        var valid = true
        if (TextUtils.isEmpty(searchEditText.text.toString()) || searchEditText.text.toString().length < 3) {
            searchEditText.error = context!!.resources.getString(R.string.edit_error)
            valid = false
        } else {
            searchEditText.error = null
        }
        return valid
    }

    interface NewsCallback {
        fun newsClick(headline: Headline)
    }

}