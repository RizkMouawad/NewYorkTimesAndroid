package com.example.newyorktimesandroid.core.di.modules


import android.content.Context
import com.example.newyorktimesandroid.App
import com.example.newyorktimesandroid.BuildConfig
import com.example.newyorktimesandroid.core.api.RestService
import com.example.newyorktimesandroid.utils.ApiVars
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    fun provideRestService(context: Context, app: App): RestService {
        return getRestService(context,app)
    }

    fun getRestService(context: Context, app: App): RestService {

        val okHttpClientBuilder = OkHttpClient.Builder()

        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        okHttpClientBuilder.connectTimeout(40, TimeUnit.SECONDS)
        okHttpClientBuilder.readTimeout(40, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG)
            okHttpClientBuilder.addInterceptor(logging)

//            okHttpClientBuilder.addInterceptor { chain ->
//                val request = chain.request().newBuilder()
//                    .addHeader("Authorization", MyPrefs.getAccessToken(context))
//                    .build()
//                chain.proceed(request)
//            }

        return Retrofit.Builder()
            .baseUrl(ApiVars.ARTICLES_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClientBuilder.build())
            .build()
            .create(RestService::class.java)

    }
}

