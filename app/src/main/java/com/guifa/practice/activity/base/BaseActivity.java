package com.guifa.practice.activity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.guifa.practice.app.GuiFaApplication;
import com.guifa.practice.manager.ActivityManager;

import butterknife.ButterKnife;

/**
 * Created by GuiFa on 2017/9/11
 * 基类activity，BaseActivity
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.instance.addActivity(this);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        this.initView();
    }

    // 获取布局layout的id
    protected abstract int getLayoutId();

    // 初始化视图
    protected abstract void initView();

    public void showToast(String message) {
        Toast.makeText(GuiFaApplication.instance, message, Toast.LENGTH_SHORT).show();
    }
}