package com.example.newyorktimesandroid.news.data.remote

import com.example.newyorktimesandroid.core.vo.Resource
import com.example.newyorktimesandroid.news.model.Response


interface NewsRemoteDataSource {

    suspend fun getNews(): Resource<Response>

}