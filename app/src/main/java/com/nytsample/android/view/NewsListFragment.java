package com.nytsample.android.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.nytsample.android.R;
import com.nytsample.android.data.model.NewsFeedItemModel;
import com.nytsample.android.data.model.NewsFeedResponseModel;
import com.nytsample.android.presenter.NewsListPresenter;
import com.nytsample.android.utils.ContextUtils;
import com.nytsample.android.view.def.NewsListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewsListFragment extends Fragment implements NewsListView, NewsFeedAdapter.NewsFeedListener {

    NewsListPresenter presenter = null;
    NewsFeedAdapter newsFeedAdapter = null;

    @BindView(R.id.rvNewsList)
    RecyclerView rvNewsList;

    @BindView(R.id.retryBtn)
    Button retryBtn;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpViews();
        presenter = new NewsListPresenter(this);
        presenter.fetchNews(0);
    }

    private void setUpViews() {
        newsFeedAdapter = new NewsFeedAdapter(this);
        rvNewsList.setAdapter(newsFeedAdapter);
        rvNewsList.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @OnClick(R.id.retryBtn)
    void onClickRetryBtn() {
        presenter.fetchNews(0);
    }

    @Override
    public void showLoading() {
        if (isAdded()) {
            rvNewsList.setVisibility(View.GONE);
            retryBtn.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showResults(NewsFeedResponseModel newsResponse) {
        if (isAdded()) {
            rvNewsList.setVisibility(View.VISIBLE);
            retryBtn.setVisibility(View.GONE);
            progressBar.setVisibility(View.GONE);

            newsFeedAdapter.update(newsResponse.results);
        }
    }

    @Override
    public void showError(String error) {
        if (isAdded()) {
            rvNewsList.setVisibility(View.GONE);
            retryBtn.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);

            ContextUtils.showToast(error);
        }
    }

    @Override
    public void onNewsFeedClicked(NewsFeedItemModel newsFeedItemModel) {
        if (getActivity() != null) {
            getActivity().getSupportFragmentManager().beginTransaction().add(android.R.id.content, NewsDetailsFragment.newInstance(newsFeedItemModel)).addToBackStack(null).commit();
        }
    }
}
