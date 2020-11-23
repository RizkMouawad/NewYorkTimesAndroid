package com.example.newyorktimesandroid.news.domain

import androidx.lifecycle.MutableLiveData
import com.example.newyorktimesandroid.core.vo.Resource
import com.example.newyorktimesandroid.news.data.repo.NewsRepository
import com.example.newyorktimesandroid.news.model.Response

class NewsUseCaseImpl constructor(private val mNewsRepository: NewsRepository) : NewsUseCase {

    override fun getNews(): MutableLiveData<Resource<Response>>  =
        mNewsRepository.getNews()

}
