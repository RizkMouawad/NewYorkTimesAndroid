package com.example.newyorktimesandroid.news.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.newyorktimesandroid.R
import com.example.newyorktimesandroid.core.base.BaseFragment
import com.example.newyorktimesandroid.core.di.ViewModelInjectionField
import com.example.newyorktimesandroid.core.di.qualifiers.ViewModelInjection
import com.example.newyorktimesandroid.news.model.NewsBean
import com.example.newyorktimesandroid.news.presentation.viewmodel.NewsViewModel
import com.example.newyorktimesandroid.utils.AppVars
import kotlinx.android.synthetic.main.fragment_news_details.view.*
import javax.inject.Inject

class NewsDetailsFragment : BaseFragment() {
    @Inject
    @ViewModelInjection
    lateinit var viewModel: ViewModelInjectionField<NewsViewModel>

    lateinit var root: View

    var newsBean: NewsBean? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_news_details, container, false)

        mActivity = activity

        newsBean = mActivity?.intent?.getSerializableExtra(AppVars.NEWS_BUNDLE) as NewsBean?

        implementViews()

        return root
    }

    private fun implementViews() {
        newsBean?.let {
            root.tvArticleTitle.text = it.title
            root.tvPublishedDate.text = it.publishedDate
            root.tvCreatedBy.text = it.byline
            root.tvDescription.text = it.abstract
            try {
                activity?.let { it1 -> Glide.with(it1).load(it?.media?.get(0)?.mediaMetadata?.get(0)?.url).into(root.ivArticleImage) }
            } catch (e: Exception) {
            }
        }
    }

}