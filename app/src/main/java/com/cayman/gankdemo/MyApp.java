package com.cayman.gankdemo;

import android.app.Application;
import android.content.Context;

import com.cayman.gankdemo.Component.AppComponent;
import com.cayman.gankdemo.Component.DaggerAppComponent;
import com.cayman.gankdemo.module.AppModule;

public class MyApp extends Application{

    private AppComponent mAppComponent;

    private static MyApp mApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        initApplicationComponent();
    }

    /**
     * 初始化ApplicationComponent
     */
    private void initApplicationComponent() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static MyApp getInstance() {
        return mApp;
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
