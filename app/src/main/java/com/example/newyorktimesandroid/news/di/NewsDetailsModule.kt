package com.example.newyorktimesandroid.news.di

import com.example.newyorktimesandroid.core.api.RestService
import com.example.newyorktimesandroid.core.di.InjectionViewModelProvider
import com.example.newyorktimesandroid.core.di.qualifiers.ViewModelInjection
import com.example.newyorktimesandroid.core.util.ResponseHandler
import com.example.newyorktimesandroid.news.data.remote.NewsRemoteDataSource
import com.example.newyorktimesandroid.news.data.remote.NewsRemoteDataSourceImpl
import com.example.newyorktimesandroid.news.data.repo.NewsRepository
import com.example.newyorktimesandroid.news.data.repo.NewsRepositoryImpl
import com.example.newyorktimesandroid.news.domain.NewsUseCase
import com.example.newyorktimesandroid.news.domain.NewsUseCaseImpl
import com.example.newyorktimesandroid.news.presentation.ui.fragments.NewsDetailsFragment
import com.example.newyorktimesandroid.news.presentation.viewmodel.NewsViewModel
import dagger.Module
import dagger.Provides

@Module
class NewsDetailsModule {

    @Provides
    @ViewModelInjection
    fun provideNewsViewModel(
        fragment: NewsDetailsFragment,
        viewModelProvider: InjectionViewModelProvider<NewsViewModel>
    ) = viewModelProvider.get(fragment, NewsViewModel::class)

    @Provides
    fun providesNewsUseCase(mNewsRepository: NewsRepository): NewsUseCase =
        NewsUseCaseImpl(mNewsRepository)

    @Provides
    fun providesNewsRepository(mNewsRemoteDataSource: NewsRemoteDataSource): NewsRepository =
        NewsRepositoryImpl(mNewsRemoteDataSource)


    @Provides
    fun providesNewsRemoteDataSource(
        restService: RestService,
        responseHandler: ResponseHandler
    ): NewsRemoteDataSource =
        NewsRemoteDataSourceImpl(restService, responseHandler)


}