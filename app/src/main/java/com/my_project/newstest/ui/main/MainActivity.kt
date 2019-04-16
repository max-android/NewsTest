package com.my_project.newstest.ui.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.app.ActionBar
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.my_project.newstest.R
import com.my_project.newstest.model.entity.Headline
import com.my_project.newstest.presentation.main.MainPresenter
import com.my_project.newstest.presentation.main.MainView
import com.my_project.newstest.router.Screens
import com.my_project.newstest.ui.detail.DetailFragment
import com.my_project.newstest.ui.news.NewsFragment
import org.jetbrains.anko.longToast

class MainActivity : MvpAppCompatActivity(), MainView, NewsFragment.NewsCallback, DetailFragment.DetailCallback {


    private val fragmentManager: FragmentManager = supportFragmentManager

    @JvmField
    @InjectPresenter
    var mPresenter: MainPresenter? = null
    var actionBar: ActionBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) openScreenNews()
        initViews()
    }

    override fun newsClick(headline: Headline) {
        mPresenter?.showScreen(fragmentManager, Screens.DETAIL_FRAGMENT, headline)
    }

    override fun linkClick(link: String) {
        val openLinkIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        if (openLinkIntent.resolveActivity(packageManager) != null) mPresenter?.showLink(this, openLinkIntent)
        else longToast(resources.getString(R.string.fails_handle_intent))
    }

    private fun openScreenNews() {
        mPresenter?.showScreen(fragmentManager, Screens.NEWS_FRAGMENT, Any())
    }

    override fun onSupportNavigateUp(): Boolean {
        mPresenter?.back(fragmentManager)
        actionBar?.setDisplayHomeAsUpEnabled(false)
        return true
    }

    private fun initViews() {
        actionBar = supportActionBar
    }
}
