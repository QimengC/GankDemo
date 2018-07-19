package com.cayman.gankdemo.module;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Provides
    public Context provideActivityContext() {
        return mActivity;
    }


    @Provides
    public Activity provideActivity() {
        return mActivity;
    }
}
