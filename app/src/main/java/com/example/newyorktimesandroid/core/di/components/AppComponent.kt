package com.example.newyorktimesandroid.core.di.components

import com.example.newyorktimesandroid.App
import com.example.newyorktimesandroid.core.di.modules.ActivityInjectorsModule
import com.example.newyorktimesandroid.core.di.modules.FragmentInjectorsModule
import com.example.newyorktimesandroid.core.di.modules.AppModule
import com.example.newyorktimesandroid.core.di.modules.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityInjectorsModule::class,
        FragmentInjectorsModule::class,
        NetworkModule::class,
        AppModule::class]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)

}