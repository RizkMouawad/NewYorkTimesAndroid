package com.example.newyorktimesandroid.news.domain

import androidx.lifecycle.MutableLiveData
import com.example.newyorktimesandroid.core.vo.Resource
import com.example.newyorktimesandroid.news.model.Response


interface NewsUseCase {

    fun getNews(): MutableLiveData<Resource<Response>>

}