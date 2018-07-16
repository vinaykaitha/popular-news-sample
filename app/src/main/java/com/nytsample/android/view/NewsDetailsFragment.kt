package com.nytsample.android.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nytsample.android.R
import com.nytsample.android.data.model.NewsFeedItemModel
import com.nytsample.android.utils.load
import com.nytsample.android.view.def.NewsDetailsView
import kotlinx.android.synthetic.main.fragment_news_details.*

class NewsDetailsFragment : Fragment(), NewsDetailsView {

    companion object {
        const val ARG_NEWS_FEED_ITEM = "news_feed_item"

        fun newInstance(newsFeedItem: NewsFeedItemModel) = NewsDetailsFragment().apply {
            val args = Bundle()
            args.putSerializable(ARG_NEWS_FEED_ITEM, newsFeedItem)
            arguments = args
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_news_details, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        val newsFeedItemModel = getNewsFeedItemArg()
        if (newsFeedItemModel != null) {
            showDetails(newsFeedItemModel)
        } else {
            throw IllegalStateException("Use NewsDetailsFragment.newInstance(newsFeedItem: NewsFeedItemModel)")
        }
    }

    override fun showDetails(newsFeedItem: NewsFeedItemModel) {
        imageViewPhoto.load(newsFeedItem.getPhotoUrl())
        textViewTitle.text = newsFeedItem.title
        textViewByLine.text = newsFeedItem.byLine
        textViewDate.text = newsFeedItem.publishedDate
    }

    private fun getNewsFeedItemArg(): NewsFeedItemModel? {
        if (arguments != null && arguments!!.containsKey(ARG_NEWS_FEED_ITEM)) {
            return arguments?.getSerializable(ARG_NEWS_FEED_ITEM) as NewsFeedItemModel
        }
        return null
    }
}