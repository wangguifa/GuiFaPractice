package com.guifa.practice.presenter;

import com.guifa.practice.beans.VideoBean;
import com.guifa.practice.http.OkHttpUtils;
import com.guifa.practice.presenter.base.BasePresenter;
import com.guifa.practice.utils.JsonUtils;
import com.guifa.practice.view.VideoView;

/**
 * Created by GuiFa on 2017/9/12
 * 视频Presenter
 */
public class VideoPresenter implements BasePresenter {

    VideoView videoView;

    public VideoPresenter() {

    }

    public VideoPresenter(VideoView videoView) {
        this.videoView = videoView;
    }

    @Override
    public void loadData(String url) {

        OkHttpUtils.get(url, new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {
                try {
                    VideoBean entity = JsonUtils.deserialize(response, VideoBean.class);
                    videoView.returnData(entity.getV9LG4B3A0());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Exception e) {
                videoView.showErrorMsg(e.getMessage());
            }
        });
    }
}