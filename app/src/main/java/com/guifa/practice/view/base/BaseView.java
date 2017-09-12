package com.guifa.practice.view.base;

/**
 * Created by GuiFa on 2017/9/12
 * 基类View
 */
public interface BaseView {
    void showLoading();

    void stopLoading();

    void showErrorMsg(String msg);
}