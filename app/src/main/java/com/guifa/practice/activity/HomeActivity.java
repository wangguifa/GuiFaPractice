package com.guifa.practice.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import com.guifa.practice.R;
import com.guifa.practice.activity.base.BaseActivity;
import com.guifa.practice.adapter.BaseFragmentAdapter;
import com.guifa.practice.fragment.MineFragment;
import com.guifa.practice.fragment.NewsFragment;
import com.guifa.practice.fragment.PictureFragment;
import com.guifa.practice.fragment.VideoFragment;
import com.guifa.practice.fragment.base.BaseFragment;
import com.guifa.practice.tools.BottomNavigationViewTools;

import butterknife.BindView;

/**
 * 首页
 */
public class HomeActivity extends BaseActivity {

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.bottomNavView)
    BottomNavigationView bottomNavView;

    int currentTabPosition = 0;
    public static final String CURRENT_TAB_POSITION = "HOME_CURRENT_TAB_POSITION";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            currentTabPosition = savedInstanceState.getInt(CURRENT_TAB_POSITION);
            viewPager.setCurrentItem(currentTabPosition);
        }
    }

    /**
     * 存储瞬间的UI状态
     *
     * @param savedInstanceState savedInstanceState
     */
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        // 奔溃前保存位置，方法执行在onStop之前
        savedInstanceState.putInt(CURRENT_TAB_POSITION, currentTabPosition);
        super.onSaveInstanceState(savedInstanceState);
    }

    /**
     * 这个方法在onStart()之后
     *
     * @param savedInstanceState savedInstanceState
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        BaseFragment[] fragments = new BaseFragment[4]; // 加载4个fragment，底部导航4个
        fragments[0] = NewsFragment.newInstance();
        fragments[1] = VideoFragment.newInstance();
        fragments[2] = PictureFragment.newInstance();
        fragments[3] = MineFragment.newInstance();
        BaseFragmentAdapter mAdapter = new BaseFragmentAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(mAdapter);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // 将当前的页面对应的底部标签设为选中状态
                bottomNavView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        BottomNavigationViewTools.disableShiftMode(bottomNavView);
        bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_news:
                        viewPager.setCurrentItem(0);
                        return true;
                    case R.id.nav_video:
                        viewPager.setCurrentItem(1);
                        return true;
                    case R.id.nav_picture:
                        viewPager.setCurrentItem(2);
                        return true;
                    case R.id.nav_mine:
                        viewPager.setCurrentItem(3);
                        return true;
                }
                return false;
            }
        });
    }
}