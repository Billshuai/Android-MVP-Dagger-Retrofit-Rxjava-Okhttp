package com.billshuai.tu.presenter;


import com.billshuai.tu.model.entity.PicturesBean;

import java.util.List;

/**
 * Created by Houge
 * tu
 */
public interface SplashContract {
    interface Presenter {
        void getImage();
    }
    interface View {
        void showLoading();
        void dismissLoading();
        void showNoData();
        void showNoMore();
        void updateUI(String url);
        void showOnFailure();
        void showLunar(String content);
    }
}
