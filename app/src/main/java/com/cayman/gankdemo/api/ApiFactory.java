package com.cayman.gankdemo.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiFactory {

    private static final int DEFAULT_TIME_OUT = 1000 * 15;

    public ApiFactory() {
    }

    public static ApiFactory getInstance() {
        return SingletonInstance.INSTANCE;
    }

    private static class SingletonInstance {
        private static final ApiFactory INSTANCE = new ApiFactory();
    }


    public GankApiService getGankApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http://gank.io/api/")
                .build();
        return retrofit.create(GankApiService.class);
    }


    private OkHttpClient getOkHttpClient() {
        // 设置 HttpLoggingInterceptor 打印数据的级别，项目上线之后可以将level设置为NONE
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIME_OUT,TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIME_OUT,TimeUnit.SECONDS)
                .build();
    }
}
