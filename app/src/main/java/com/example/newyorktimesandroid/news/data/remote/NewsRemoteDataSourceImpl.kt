package com.example.newyorktimesandroid.news.data.remote

import javax.inject.Inject
import com.example.newyorktimesandroid.core.api.RestService
import com.example.newyorktimesandroid.core.util.ResponseHandler
import com.example.newyorktimesandroid.core.vo.Resource
import com.example.newyorktimesandroid.news.model.Response


class NewsRemoteDataSourceImpl constructor(
    private val restService: RestService,
    private val responseHandler: ResponseHandler
) : NewsRemoteDataSource {
    override suspend fun getNews(): Resource<Response> {
        return try {
            responseHandler.handleSuccess(restService.getNews())
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }


}
