package com.my_project.newstest.ui.news

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
import com.my_project.newstest.R
import com.my_project.newstest.model.entity.Headline

/**
 * Created Максим on 16.04.2019.
 * Copyright © Max
 */
class NewsAdapter (private val action: (Headline) -> Unit) : RecyclerView.Adapter<NewsAdapter.NewsHolder>() {

    private val items: MutableList<Headline> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsHolder(view)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        val user = items[position]
        holder.bindTo(user)
    }

    override fun getItemCount() = items.size

    fun setData(news: List<Headline>) {
        items.clear()
        items.addAll(news)
        notifyDataSetChanged()
    }


    fun clear(){
        items.clear()
        notifyDataSetChanged()
    }

    inner class NewsHolder(private val containerView: View) : RecyclerView.ViewHolder(containerView) {

        private var name = containerView.findViewById(R.id.titleTextView) as TextView
        private var date = containerView.findViewById(R.id.dateTextView) as TextView
        private var image = containerView.findViewById(R.id.newsImageView) as SimpleDraweeView

        init {
            containerView.setOnClickListener { action(items[layoutPosition]) }
        }

        fun bindTo(headline: Headline) = with(headline) {
            name.text = title
            date.text = headline.data.replace("T"," ").replace("Z","")
            image.setImageURI(urlImage)
        }
    }
}