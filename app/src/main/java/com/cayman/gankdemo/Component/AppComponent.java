package com.cayman.gankdemo.Component;

import android.content.Context;

import com.cayman.gankdemo.MyApp;
import com.cayman.gankdemo.module.AppModule;

import dagger.Component;

@Component(modules = {AppModule.class})
public interface AppComponent {

    MyApp getApplication();

//    Context getApplicationContext();
}
