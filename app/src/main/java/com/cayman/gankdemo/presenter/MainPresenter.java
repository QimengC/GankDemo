package com.cayman.gankdemo.presenter;

import com.cayman.gankdemo.base.BaseObserver;
import com.cayman.gankdemo.base.BasePresenter;
import com.cayman.gankdemo.model.GankModel;
import com.cayman.gankdemo.bean.GankBean;
import com.cayman.gankdemo.contract.MainContract;


import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private GankModel gankModel;

    @Inject
    public MainPresenter() {
        gankModel = new GankModel();
    }


    @Override
    public void getData(int pagesize, int page) {
        gankModel.getData(pagesize,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<GankBean>() {
                    @Override
                    public void onSuccess(GankBean gankBean) {
                        mView.showSuccess(gankBean.getResults());
                    }

                    @Override
                    public void onFail(Throwable e) {
                        mView.showFaild();
                    }
                });
    }
}
