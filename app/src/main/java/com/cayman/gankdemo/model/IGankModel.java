package com.cayman.gankdemo.model;


import com.cayman.gankdemo.bean.GankBean;

import io.reactivex.Observable;

public interface IGankModel {
    Observable<GankBean> getData(int pagesize, int page);
}
