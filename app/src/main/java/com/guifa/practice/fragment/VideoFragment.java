package com.guifa.practice.fragment;

import android.os.Bundle;

import com.guifa.practice.R;
import com.guifa.practice.fragment.base.BaseFragment;

/**
 * Created by GuiFa on 2017/9/11
 * 视频页
 */
public class VideoFragment extends BaseFragment {

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

    }

    @Override
    protected void lazyFetchData() {

    }
}