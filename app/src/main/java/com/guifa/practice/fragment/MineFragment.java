package com.guifa.practice.fragment;

import android.os.Bundle;

import com.guifa.practice.R;
import com.guifa.practice.fragment.base.BaseFragment;

/**
 * Created by GuiFa on 2017/9/11
 * 我的页
 */
public class MineFragment extends BaseFragment {

    public static MineFragment newInstance() {

        Bundle args = new Bundle();

        MineFragment fragment = new MineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void lazyFetchData() {

    }
}