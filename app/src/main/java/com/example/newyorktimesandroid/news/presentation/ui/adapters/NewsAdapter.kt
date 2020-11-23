package com.example.newyorktimesandroid.news.presentation.ui.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newyorktimesandroid.R
import com.example.newyorktimesandroid.news.model.NewsBean
import com.example.newyorktimesandroid.utils.LocalFunctions
import de.hdodenhof.circleimageview.CircleImageView


class NewsAdapter(
    val context: Activity, val news: ArrayList<NewsBean>?
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

            val holder: NewsViewHolder = viewHolder
            val newsItem: NewsBean? = news?.get(position)
            holder.tvArticleTitle?.text = newsItem?.title
            holder.tvPublishedDate?.text = newsItem?.publishedDate
            holder.tvCreatedBy?.text = newsItem?.byline

            holder.rlArticle?.setOnClickListener {
                newsItem?.let { it1 -> LocalFunctions.goToNewsDetailsScreen(context, it1) }
            }
            holder.ivArticleImage?.let {
                try {
                    Glide.with(context).load(newsItem?.media?.get(0)?.mediaMetadata?.get(0)?.url).into(
                        it
                    )
                } catch (e: Exception) {
                }
            }
        }
    }

    class NewsViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_news, parent, false)) {
        var ivArticleImage: CircleImageView? = null
        var rlArticle: RelativeLayout? = null
        var tvArticleTitle: TextView? = null
        var tvCreatedBy: TextView? = null
        var tvPublishedDate: TextView? = null

        init {
            ivArticleImage = itemView.findViewById(R.id.ivArticleImage)
            rlArticle = itemView.findViewById(R.id.rlArticle)
            tvArticleTitle = itemView.findViewById(R.id.tvArticleTitle)
            tvCreatedBy = itemView.findViewById(R.id.tvCreatedBy)
            tvPublishedDate = itemView.findViewById(R.id.tvPublishedDate)

        }
    }

}