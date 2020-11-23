package com.example.newyorktimesandroid.core.di.modules

import android.app.Application
import android.content.Context
import com.example.newyorktimesandroid.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideApplication(app: App): Application = app

    @Provides
    @Singleton
    fun provideApplicationContext(app: App): Context = app.applicationContext

}