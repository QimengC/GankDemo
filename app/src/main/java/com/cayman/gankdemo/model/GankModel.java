package com.cayman.gankdemo.model;

import com.cayman.gankdemo.api.ApiFactory;
import com.cayman.gankdemo.api.GankApiService;
import com.cayman.gankdemo.bean.GankBean;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class GankModel implements IGankModel {

    @Override
    public Observable<GankBean> getData(int pagesize, int page) {
        return ApiFactory.getInstance().getGankApi().getData(pagesize,page);
    }

//        OkHttpClient client = new OkHttpClient().newBuilder()
//                .addInterceptor(new HttpLoggingInterceptor())
//                .connectTimeout(1000 * 20, TimeUnit.SECONDS)
//                .build();
//
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://gank.io/api/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .client(client)
//                .build();
//
//        GankApiService gankApi = retrofit.create(GankApiService.class);
//        gankApi.getData(10,1)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<GankBean>() {
//
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(GankBean gankBean) {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//    }

}
