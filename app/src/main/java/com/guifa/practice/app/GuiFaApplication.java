package com.guifa.practice.app;

import android.app.Application;

/**
 * Created by GuiFa on 2017/9/11
 * 基类Application
 */
public class GuiFaApplication extends Application {

    public static GuiFaApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}