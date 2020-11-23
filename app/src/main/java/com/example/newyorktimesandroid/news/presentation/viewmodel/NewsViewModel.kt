package com.example.newyorktimesandroid.news.presentation.viewmodel


import androidx.lifecycle.MutableLiveData
import com.example.newyorktimesandroid.core.base.BaseViewModel
import com.example.newyorktimesandroid.core.vo.Resource
import com.example.newyorktimesandroid.news.domain.NewsUseCase
import com.example.newyorktimesandroid.news.model.Response
import javax.inject.Inject


class NewsViewModel @Inject constructor(
    private val mNewsUseCase: NewsUseCase
) : BaseViewModel() {

    var response: MutableLiveData<Resource<Response>> = MutableLiveData()

    fun getNews() {
        response = mNewsUseCase.getNews()
    }
}