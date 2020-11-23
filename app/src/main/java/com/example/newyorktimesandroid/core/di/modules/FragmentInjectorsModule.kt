package com.example.newyorktimesandroid.core.di.modules


import com.example.newyorktimesandroid.news.di.NewsDetailsModule
import com.example.newyorktimesandroid.news.di.NewsModule
import com.example.newyorktimesandroid.news.presentation.ui.fragments.NewsDetailsFragment
import com.example.newyorktimesandroid.news.presentation.ui.fragments.NewsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentInjectorsModule {

      @ContributesAndroidInjector(modules = [NewsModule::class])
      abstract fun newsFragmentInjector(): NewsFragment

      @ContributesAndroidInjector(modules = [NewsDetailsModule::class])
      abstract fun newsDetailsFragmentInjector(): NewsDetailsFragment

}