package com.guifa.practice.fragment;

import android.os.Bundle;

import com.guifa.practice.R;
import com.guifa.practice.fragment.base.BaseFragment;

/**
 * Created by GuiFa on 2017/9/11
 * 图片页
 */
public class PictureFragment extends BaseFragment {

    public static PictureFragment newInstance() {

        Bundle args = new Bundle();

        PictureFragment fragment = new PictureFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_picture;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void lazyFetchData() {

    }
}