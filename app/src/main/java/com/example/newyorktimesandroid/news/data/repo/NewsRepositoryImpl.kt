package com.example.newyorktimesandroid.news.data.repo


import androidx.lifecycle.MutableLiveData
import com.example.newyorktimesandroid.core.vo.Resource
import com.example.newyorktimesandroid.news.data.remote.NewsRemoteDataSource
import com.example.newyorktimesandroid.news.model.Response
import kotlinx.coroutines.*
import retrofit2.HttpException


class NewsRepositoryImpl constructor(
    private val remoteDataSource: NewsRemoteDataSource
) : NewsRepository {
    private var mutableLiveData = MutableLiveData<Resource<Response>>()
    private val completableJob = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.IO + completableJob)
    override fun getNews(): MutableLiveData<Resource<Response>> {
        mutableLiveData = MutableLiveData()
        mutableLiveData.value = Resource.loading(null)
        coroutineScope.launch {
            val request = remoteDataSource.getNews()
            withContext(Dispatchers.Main) {
                try {
                    mutableLiveData.value = request
                } catch (e: HttpException) {
                    // Log exception //

                } catch (e: Throwable) {
                    // Log error //)
                }
            }
        }
        return mutableLiveData
    }

}