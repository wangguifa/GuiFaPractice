package com.guifa.practice.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.guifa.practice.R;
import com.guifa.practice.adapter.BaseFragmentAdapter;
import com.guifa.practice.fragment.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by GuiFa on 2017/9/11
 * 新闻页
 */
public class NewsFragment extends BaseFragment {

    public static final int ONE = 0;
    public static final int TWO = 1;
    public static final int THREE = 2;
    public static final int FOUR = 3;

    @BindView(R.id.newTabLayout)
    TabLayout newTabLayout;
    @BindView(R.id.newsViewPager)
    ViewPager newsViewPager;

    private String[] titles = {"头条", "NBA", "汽车", "笑话"};

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
        BaseFragment[] mFragments = new BaseFragment[4];
        mFragments[0] = NewsEachFragment.newInstance(ONE);
        mFragments[1] = NewsEachFragment.newInstance(TWO);
        mFragments[2] = NewsEachFragment.newInstance(THREE);
        mFragments[3] = NewsEachFragment.newInstance(FOUR);
        newTabLayout.setTabMode(TabLayout.MODE_FIXED);
        BaseFragmentAdapter mAdapter = new BaseFragmentAdapter(getChildFragmentManager(), mFragments, titles);
        newsViewPager.setAdapter(mAdapter);
        newTabLayout.setupWithViewPager(newsViewPager);
    }

    @Override
    protected void lazyFetchData() {

    }
}