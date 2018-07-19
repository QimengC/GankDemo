package com.cayman.gankdemo.module;

import android.content.Context;

import com.cayman.gankdemo.MyApp;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private MyApp mApplication;

    public AppModule(MyApp Application) {
        this.mApplication = Application ;
    }

    @Provides
    MyApp provideApplication() {
        return mApplication;
    }

//    @Provides
//    Context provideApplicationContext() {
//        return mApplication.getApplicationContext();
//    }
}
