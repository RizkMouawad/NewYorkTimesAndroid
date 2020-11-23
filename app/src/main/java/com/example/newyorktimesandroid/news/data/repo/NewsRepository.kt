package com.example.newyorktimesandroid.news.data.repo

import androidx.lifecycle.MutableLiveData
import com.example.newyorktimesandroid.core.vo.Resource
import com.example.newyorktimesandroid.news.model.Response

interface NewsRepository {

    fun getNews(): MutableLiveData<Resource<Response>>

}