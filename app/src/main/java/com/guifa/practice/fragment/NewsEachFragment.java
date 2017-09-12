package com.guifa.practice.fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.guifa.practice.R;
import com.guifa.practice.fragment.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by GuiFa on 2017/9/12
 * 新闻页面下的每个Fragment
 */
public class NewsEachFragment extends BaseFragment {

    @BindView(R.id.id)
    TextView textView;
    int msg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            msg = getArguments().getInt("currentPosition");
        }
    }

    public static NewsEachFragment newInstance(int currentPosition) {
        Bundle args = new Bundle();
        args.putInt("currentPosition", currentPosition);
        NewsEachFragment fragment = new NewsEachFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news_each;
    }

    @Override
    protected void initView() {
        textView.setText("这是第" + msg + "页面");
    }

    @Override
    protected void lazyFetchData() {

    }
}