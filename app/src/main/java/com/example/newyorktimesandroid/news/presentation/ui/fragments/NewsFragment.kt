package com.example.newyorktimesandroid.news.presentation.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newyorktimesandroid.R
import com.example.newyorktimesandroid.core.base.BaseFragment
import com.example.newyorktimesandroid.core.di.ViewModelInjectionField
import com.example.newyorktimesandroid.core.di.qualifiers.ViewModelInjection
import com.example.newyorktimesandroid.core.vo.Status
import com.example.newyorktimesandroid.news.model.Response
import com.example.newyorktimesandroid.news.presentation.ui.adapters.NewsAdapter
import com.example.newyorktimesandroid.news.presentation.viewmodel.NewsViewModel
import com.example.newyorktimesandroid.utils.NetworkUtils
import kotlinx.android.synthetic.main.fragment_news.view.*
import javax.inject.Inject


class NewsFragment : BaseFragment() {

    @Inject
    @ViewModelInjection
    lateinit var viewModel: ViewModelInjectionField<NewsViewModel>

    lateinit var root: View


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_news, container, false)

        implementViews()

        return root
    }

    private fun implementViews() {
        getNews()

        root.srlNews.setOnRefreshListener {
            getNews()
        }
    }

    private fun getNews() {
        viewModel.get().getNews()
        viewModel.get().response.removeObservers(viewLifecycleOwner)
        viewModel.get().response.observe(viewLifecycleOwner,
            androidx.lifecycle.Observer { repos ->
                repos?.let {
                    when (repos.status) {
                        Status.LOADING -> {
                            showLoading()
                        }
                        Status.ERROR -> {
                            hideLoading()
                                if (!NetworkUtils.isNetworkAvailable(requireActivity())) {
                                    Toast.makeText(
                                        requireActivity(),
                                        getString(R.string.msg_no_internet_connection),
                                        Toast.LENGTH_LONG
                                    ).show()
                                }
                        }
                        Status.SUCCESS -> {
                            hideLoading()
                            addViews(repos.data)
                        }
                    }
                }
            })
    }

    private fun addViews(data: Response?) {
        root.rvNews?.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL, false
        )
        root.rvNews?.adapter = NewsAdapter(data?.data)
    }

    private fun showLoading() {
        root.srlNews.isRefreshing = true
    }

    private fun hideLoading() {
        root.srlNews.isRefreshing = false
    }


}
