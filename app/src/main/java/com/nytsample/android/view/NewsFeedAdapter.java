package com.nytsample.android.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nytsample.android.R;
import com.nytsample.android.data.model.NewsFeedItemModel;
import com.nytsample.android.utils.ImageViewUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedAdapter.NewsItemHolder> {
    private final NewsFeedListener listener;
    private List<NewsFeedItemModel> newsFeedList = new ArrayList<>();

    public interface NewsFeedListener {
        void onNewsFeedClicked(NewsFeedItemModel newsFeedItemModel);
    }

    public NewsFeedAdapter(NewsFeedListener listener) {
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return newsFeedList.size();
    }

    @NonNull
    @Override
    public NewsItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_news_list_card, parent, false);
        return new NewsItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsFeedAdapter.NewsItemHolder holder, int position) {
        final NewsFeedItemModel newsFeedItem = newsFeedList.get(position);

        ImageViewUtils.loadImage(holder.photo, newsFeedItem.getPhotoUrl());
        holder.title.setText(newsFeedItem.title);
        holder.byLine.setText(newsFeedItem.byLine);
        holder.date.setText(newsFeedItem.publishedDate);

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onNewsFeedClicked(newsFeedItem);
            }
        });
    }

    public void update(List<NewsFeedItemModel> results) {
        newsFeedList.addAll(results);
        notifyDataSetChanged();
    }

    public static class NewsItemHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.container)
        View container;
        @BindView(R.id.imageViewPhoto)
        ImageView photo;
        @BindView(R.id.textViewTitle)
        TextView title;
        @BindView(R.id.textViewByLine)
        TextView byLine;
        @BindView(R.id.textViewDate)
        TextView date;

        public NewsItemHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
