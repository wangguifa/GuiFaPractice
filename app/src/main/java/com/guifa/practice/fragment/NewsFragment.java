package com.guifa.practice.fragment;

import android.os.Bundle;

import com.guifa.practice.R;
import com.guifa.practice.fragment.base.BaseFragment;

/**
 * Created by GuiFa on 2017/9/11
 * 新闻页
 */
public class NewsFragment extends BaseFragment{

    public static NewsFragment newInstance() {
        Bundle args = new Bundle();
        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void lazyFetchData() {

    }
}