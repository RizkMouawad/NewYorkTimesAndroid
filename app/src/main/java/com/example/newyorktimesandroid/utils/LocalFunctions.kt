package com.example.newyorktimesandroid.utils

import android.app.Activity
import android.content.Intent
import com.example.newyorktimesandroid.news.model.NewsBean
import com.example.newyorktimesandroid.news.presentation.ui.activities.NewsDetailsActivity

class LocalFunctions {

    companion object {
        fun goToNewsDetailsScreen(activity: Activity, newsBean: NewsBean) {
            var intent = Intent(activity, NewsDetailsActivity::class.java)
            intent.putExtra(AppVars.NEWS_BUNDLE, newsBean)
            activity.startActivity(intent)
        }
    }

}