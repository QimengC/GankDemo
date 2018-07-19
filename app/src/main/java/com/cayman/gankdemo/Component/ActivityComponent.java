package com.cayman.gankdemo.Component;

import android.app.Activity;
import android.content.Context;

import com.cayman.gankdemo.module.ActivityModule;
import com.cayman.gankdemo.view.MainActivity;

import dagger.Component;

@Component(dependencies = AppComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {

    Context getActivityContext();

    Activity getActivity();

    void inject(MainActivity mainActivity);

//    void inject(SecondActivity secondActivity)
//    void inject(ThirdActivity thirdActivity)


}
