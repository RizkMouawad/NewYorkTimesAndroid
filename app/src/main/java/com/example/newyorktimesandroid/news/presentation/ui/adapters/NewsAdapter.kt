package com.example.newyorktimesandroid.news.presentation.ui.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newyorktimesandroid.R
import com.example.newyorktimesandroid.news.model.NewsBean
import com.example.newyorktimesandroid.utils.LocalFunctions
import kotlinx.android.synthetic.main.item_news.view.tvArticleTitle
import kotlinx.android.synthetic.main.item_news.view.tvCreatedBy
import kotlinx.android.synthetic.main.item_news.view.tvPublishedDate
import kotlinx.android.synthetic.main.item_news.view.*


class NewsAdapter(
    val news: ArrayList<NewsBean>?
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return if (news.isNullOrEmpty()) 0 else news.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NewsViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        if (viewHolder is NewsViewHolder) {
            val newsItem: NewsBean? = news?.get(position)
            viewHolder.itemView.tvArticleTitle.text = newsItem?.title
            viewHolder.itemView.tvPublishedDate.text = newsItem?.publishedDate
            viewHolder.itemView.tvCreatedBy.text = newsItem?.byline

            viewHolder.itemView.rlArticle.setOnClickListener {
                newsItem?.let { it1 -> LocalFunctions.goToNewsDetailsScreen(viewHolder.itemView.context as Activity, it1) }
            }
                try {
                    Glide.with(viewHolder.itemView.context).load(newsItem?.media?.get(0)?.mediaMetadata?.get(0)?.url).into(
                        viewHolder.itemView.ivArticleImage
                    )
                } catch (e: Exception) {
                }
            }
        }
    }

    class NewsViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_news, parent, false))