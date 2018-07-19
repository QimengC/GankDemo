package com.cayman.gankdemo.module;

import com.cayman.gankdemo.api.GankApiService;

import java.io.File;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class HttpModule {

    private static final int DEFAULT_TIME_OUT = 1000 * 15;
    private static final int CACHE_SIZE = 1024 * 1024 * 100;

    @Provides
    OkHttpClient provideOkHttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

//        Cache cache = new Cache(new File(MyApp.getContext().getCacheDir(), "HttpCache"),
//                1024 * 1024 * 100);

        return new OkHttpClient().newBuilder()
//                .cache(cache)
                .addInterceptor(loggingInterceptor)
                .readTimeout(DEFAULT_TIME_OUT,TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIME_OUT,TimeUnit.SECONDS)
                .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http://gank.io/api/")
                .build();
    }

    @Provides
    GankApiService provideGankApi(Retrofit retrofit) {
        return retrofit.create(GankApiService.class);
    }



}
