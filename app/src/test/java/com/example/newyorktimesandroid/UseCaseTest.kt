package com.example.newyorktimesandroid

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.example.newyorktimesandroid.core.vo.Resource
import com.example.newyorktimesandroid.news.domain.NewsUseCaseImpl
import com.example.newyorktimesandroid.news.model.Response
import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.disposables.Disposable
import io.reactivex.internal.schedulers.ExecutorScheduler
import io.reactivex.plugins.RxJavaPlugins
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit

class Test {
    @get:Rule
    var rule = InstantTaskExecutorRule()

    @Mock
    lateinit var newsUseCaseImpl: NewsUseCaseImpl

    private lateinit var testSingle: MutableLiveData<Resource<Response>>

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Before
    fun setupJavaRx() {
        val immediate = object : Scheduler() {
            override fun scheduleDirect(run: Runnable?, delay: Long, unit: TimeUnit?): Disposable {
                return super.scheduleDirect(run, 0, unit)
            }

            override fun createWorker(): Worker {
                return ExecutorScheduler.ExecutorWorker(Executor { it.run() })
            }
        }

        RxJavaPlugins.setInitIoSchedulerHandler { scheduler -> immediate }
        RxJavaPlugins.setInitComputationSchedulerHandler { scheduler -> immediate }
        RxJavaPlugins.setInitNewThreadSchedulerHandler { scheduler -> immediate }
        RxJavaPlugins.setSingleSchedulerHandler { scheduler -> immediate }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler -> immediate }

    }

    @Test
    fun getNewsSizeSuccess() {
        testSingle = MutableLiveData()
        val newsResponse = Response(ArrayList())
        testSingle.value = Resource.success(newsResponse)
        Mockito.`when`(newsUseCaseImpl.getNews()).thenReturn(testSingle)
        newsUseCaseImpl.getNews()
        Assert.assertEquals(0, newsUseCaseImpl.getNews().value?.data?.data?.size)
    }

    @Test
    fun getNewsSizeError() {
        testSingle = MutableLiveData()
        val newsResponse = Response(ArrayList())
        testSingle.value = Resource.success(newsResponse)
        Mockito.`when`(newsUseCaseImpl.getNews()).thenReturn(testSingle)
        newsUseCaseImpl.getNews()
        newsUseCaseImpl.getNews().value?.data?.data?.size?.equals(5)?.let { Assert.assertFalse(it) }
    }

}