package com.nytsample.android.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.nytsample.android.R
import com.nytsample.android.data.model.NewsFeedItemModel
import com.nytsample.android.utils.load
import kotlinx.android.synthetic.main.layout_news_list_card.view.*

class NewsFeedAdapter(private val clickNewsFeedItemCallback: (NewsFeedItemModel) -> Unit) : RecyclerView.Adapter<NewsFeedAdapter.NewsItemHolder>() {

    private val newsFeedList = mutableListOf<NewsFeedItemModel>()

    override fun getItemCount() = newsFeedList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_news_list_card, parent, false)
        return NewsItemHolder(v)
    }

    override fun onBindViewHolder(holder: NewsItemHolder, position: Int) {
        val newsFeedItem = newsFeedList[position]

        holder.photo.load(newsFeedItem.getPhotoUrl())
        holder.title.text = newsFeedItem.title
        holder.byLine.text = newsFeedItem.byLine
        holder.date.text = newsFeedItem.publishedDate

        holder.container.setOnClickListener {
            clickNewsFeedItemCallback(newsFeedItem)
        }
    }

    fun update(results: List<NewsFeedItemModel>) {
        newsFeedList.addAll(results)
        notifyDataSetChanged()
    }

    class NewsItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var container: View = itemView.container
        var photo: ImageView = itemView.imageViewPhoto
        var title: TextView = itemView.textViewTitle
        var byLine: TextView = itemView.textViewByLine
        var date: TextView = itemView.textViewDate
    }
}