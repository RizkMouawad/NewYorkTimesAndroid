package com.example.newyorktimesandroid.news.model

import com.google.gson.annotations.SerializedName

class Response(
    @SerializedName("results")
    val data: ArrayList<NewsBean>
)