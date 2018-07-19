package com.cayman.gankdemo.contract;

import com.cayman.gankdemo.base.BaseContract;
import com.cayman.gankdemo.bean.GankBean;

import java.util.List;

public interface MainContract {

    interface View extends BaseContract.BaseView {

        void showSuccess(List<GankBean.ResultsBean> list);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {

        void getData(int pagesize,int page);
    }

}
