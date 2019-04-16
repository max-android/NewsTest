package com.my_project.newstest.ui.detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.my_project.newstest.R
import com.my_project.newstest.model.entity.Headline
import com.my_project.newstest.presentation.detail.DetailPresenter
import com.my_project.newstest.presentation.detail.DetailView
import com.my_project.newstest.ui.common.FragmentKeys
import com.my_project.newstest.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_detail_news.*

/**
 * Created Максим on 16.04.2019.
 * Copyright © Max
 */
class DetailFragment : MvpAppCompatFragment(), DetailView {


    companion object {
        fun newInstance(headline: Headline): DetailFragment {
            val fragment = DetailFragment()
            val args = Bundle()
            args.putSerializable(FragmentKeys.DETAIL_NEWS_KEY, headline)
            fragment.arguments = args
            return fragment
        }
    }

    @JvmField
    @InjectPresenter
    var detailPresenter: DetailPresenter? = null
    private var detailCallback: DetailCallback? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is DetailCallback) {
            detailCallback = context
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail_news, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViews()
    }

    override fun onDetach() {
        super.onDetach()
        detailCallback = null
    }

    override fun showWebVersion(url: String) {
        detailCallback?.linkClick(url)
    }

    private fun headline() = arguments?.getSerializable(FragmentKeys.DETAIL_NEWS_KEY)

    private fun initViews() {
        val actionBar = (activity as MainActivity).actionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        (headline() as? Headline)?.let {
            detailNewsImageView.setImageURI(it.urlImage)
            descriptionTextView.text = it.description
            linkTextView.setOnClickListener { v -> detailPresenter?.onLinkClick(it.url) }
            sourceTextView.text = it.source.name
            authorTextView.text = it.author
            actionBar?.title = it.title
        }
    }

    interface DetailCallback {
        fun linkClick(link: String)
    }

}