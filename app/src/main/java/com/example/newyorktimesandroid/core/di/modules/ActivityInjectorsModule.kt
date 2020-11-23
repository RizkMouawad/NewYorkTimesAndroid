package com.example.newyorktimesandroid.core.di.modules

import com.example.newyorktimesandroid.news.presentation.ui.activities.NewsActivity
import com.example.newyorktimesandroid.news.presentation.ui.activities.NewsDetailsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityInjectorsModule {

    @ContributesAndroidInjector
    abstract fun newsActivityInjector(): NewsActivity

    @ContributesAndroidInjector
    abstract fun newsDetailsActivityInjector(): NewsDetailsActivity

}