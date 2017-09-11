package com.guifa.practice.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.guifa.practice.fragment.base.BaseFragment;

/**
 * Created by GuiFa on 2017/9/11
 * 通用的FragmentAdapter
 */
public class BaseFragmentAdapter extends FragmentPagerAdapter {

    private FragmentManager fm;
    private BaseFragment[] fragmentList;
    private String[] mTitles;

    public BaseFragmentAdapter(FragmentManager fm, BaseFragment[] fragmentList) {
        super(fm);
        this.fm = fm;
        this.fragmentList = fragmentList;
    }

    public BaseFragmentAdapter(FragmentManager fm, BaseFragment[] fragmentList, String[] mTitles) {
        super(fm);
        this.fm = fm;
        this.fragmentList = fragmentList;
        this.mTitles = mTitles;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles == null ? "" : mTitles[position];
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList[position];
    }

    @Override
    public int getCount() {
        return (fragmentList == null) ? 0 : fragmentList.length;
    }

    /**
     * 这边并没有创建销毁过程，只创建一次
     *
     * @param container container
     * @param position  position
     * @return Fragment
     */
    @Override
    public Fragment instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        fm.beginTransaction().show(fragment).commitAllowingStateLoss();
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Fragment fragment = fragmentList[position];
        fm.beginTransaction().hide(fragment).commitAllowingStateLoss();
    }
}