package com.cayman.gankdemo.base;


public interface BaseContract {

    interface BasePresenter<T extends BaseContract.BaseView> {

        void attachView(T view);

        void detachView();
    }


    interface BaseView {

        //显示进度中
        void showLoading();

        //失败重试
        void showFaild();

    }
}
