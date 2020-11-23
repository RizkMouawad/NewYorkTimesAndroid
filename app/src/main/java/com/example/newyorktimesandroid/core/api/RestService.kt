package com.example.newyorktimesandroid.core.api

import androidx.lifecycle.LiveData
import com.example.newyorktimesandroid.core.vo.Resource
import com.example.newyorktimesandroid.news.model.Response
import retrofit2.http.GET

interface RestService {


      @GET("viewed/7.json?api-key=Rk6GfVjL9XA3A5ipo7bjr2fNh80CpeA5")
      suspend fun getNews(): Response


}