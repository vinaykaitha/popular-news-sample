package com.nytsample.android.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nytsample.android.R
import com.nytsample.android.data.model.NewsFeedItemModel
import com.nytsample.android.data.model.NewsFeedResponseModel
import com.nytsample.android.presenter.NewsListPresenter
import com.nytsample.android.utils.toast
import com.nytsample.android.view.def.NewsListView
import kotlinx.android.synthetic.main.fragment_news_list.*

class NewsListFragment : Fragment(), NewsListView {

    private val presenter: NewsListPresenter by lazy { NewsListPresenter(this) }

    private val newsFeedAdapter by lazy { NewsFeedAdapter(this::onNewsFeedClicked) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_news_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setUpViews()

        presenter.fetchNews()
    }

    private fun setUpViews() {
        rvNewsList.adapter = newsFeedAdapter
        rvNewsList.layoutManager = LinearLayoutManager(activity)

        retryBtn.setOnClickListener {
            presenter.fetchNews()
        }
    }

    override fun showLoading() {
        if (isAdded) {
            rvNewsList.visibility = View.GONE
            retryBtn.visibility = View.GONE
            progressBar.visibility = View.VISIBLE
        }
    }

    override fun showResults(newsResponse: NewsFeedResponseModel) {
        if (isAdded) {
            rvNewsList.visibility = View.VISIBLE
            retryBtn.visibility = View.GONE
            progressBar.visibility = View.GONE

            newsFeedAdapter.update(newsResponse.results)
        }
    }

    override fun showError(error: String) {
        if (isAdded) {
            rvNewsList.visibility = View.GONE
            retryBtn.visibility = View.VISIBLE
            progressBar.visibility = View.GONE
            activity?.toast(error)
        }
    }

    private fun onNewsFeedClicked(newsFeedItem: NewsFeedItemModel) {
        activity?.supportFragmentManager?.beginTransaction()?.add(R.id.content, NewsDetailsFragment.newInstance(newsFeedItem), null)?.addToBackStack(null)?.commit()
    }
}