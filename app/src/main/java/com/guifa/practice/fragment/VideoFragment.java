package com.guifa.practice.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.guifa.practice.R;
import com.guifa.practice.beans.VideoBean;
import com.guifa.practice.fragment.base.BaseFragment;
import com.guifa.practice.presenter.VideoPresenter;
import com.guifa.practice.recycleview.BaseRVAdapter;
import com.guifa.practice.recycleview.BaseRVViewHolder;
import com.guifa.practice.recycleview.EndLessOnScrollListener;
import com.guifa.practice.utils.ImageLoaderUtils;
import com.guifa.practice.view.VideoView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by GuiFa on 2017/9/11
 * 视频页
 */
public class VideoFragment extends BaseFragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;

    private BaseRVAdapter mAdapter;
    private List<VideoBean.V9LG4B3A0Bean> videoList = new ArrayList<>();
    private int pageIndex = 0;
    private VideoPresenter mPresenter;
    private String videoUrl = "http://c.m.163.com/nc/video/list/V9LG4B3A0/n/0-10.html";

    public static VideoFragment newInstance() {
        Bundle args = new Bundle();
        VideoFragment fragment = new VideoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initView() {
        mPresenter = new VideoPresenter(new VideoView() {
            @Override
            public void returnData(List<VideoBean.V9LG4B3A0Bean> dataList) {
                if (pageIndex == 0) {
                    mAdapter.replaceAll(dataList);
                    refreshLayout.setRefreshing(false);
                } else {
                    mAdapter.addAll(dataList);
                    mAdapter.setFooterVisible(View.GONE);
                }
            }

            @Override
            public void showLoading() {

            }

            @Override
            public void stopLoading() {

            }

            @Override
            public void showErrorMsg(String msg) {
                Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
                refreshLayout.setRefreshing(false);
            }
        });
        refreshLayout.setColorSchemeResources(R.color.colorPrimary, android.R.color.holo_red_light,
                android.R.color.holo_orange_light, android.R.color.holo_green_light);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pageIndex = 0;
                videoList.clear();
                mPresenter.loadData(videoUrl);
            }
        });
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new BaseRVAdapter<VideoBean.V9LG4B3A0Bean>(getActivity(), R.layout.item_video, videoList) {
            @Override
            public void convert(BaseRVViewHolder viewHolder, VideoBean.V9LG4B3A0Bean item) {
                viewHolder.setText(R.id.title, item.getTitle());
                viewHolder.setText(R.id.source, item.getVideosource());
                ImageView imageView = viewHolder.getView(R.id.cover);
                ImageView circleImageView = viewHolder.getView(R.id.topicImg);
                ImageLoaderUtils.loadingImg(getActivity(), imageView, item.getCover());
                ImageLoaderUtils.displayRound(getActivity(), circleImageView, item.getTopicImg());
            }
        };
        mAdapter.setOnItemClickLitener(new BaseRVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, BaseRVViewHolder viewHolder) {
                if (videoList.size() > 0) {
//                    VideoDetailActivity.launch(getActivity(), videoList.get(position).getMp4_url(), videos.get(position).getTitle(), pageIndex);
                }
            }

            @Override
            public void onItemLongClick(int position) {
            }
        });
        recyclerView.setAdapter(mAdapter);
        mAdapter.addFooterView(R.layout.layout_footer);
        recyclerView.addOnScrollListener(new EndLessOnScrollListener(manager) {
            @Override
            public void onLoadMore() {
                pageIndex++;
                mAdapter.setFooterVisible(View.VISIBLE);
                mPresenter.loadData(videoUrl);
            }
        });
    }

    @Override
    protected void lazyFetchData() {
        refreshLayout.setRefreshing(true);
        mPresenter.loadData(videoUrl);
    }
}