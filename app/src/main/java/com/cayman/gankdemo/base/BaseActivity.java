package com.cayman.gankdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.cayman.gankdemo.Component.ActivityComponent;
import com.cayman.gankdemo.Component.AppComponent;
import com.cayman.gankdemo.Component.DaggerActivityComponent;
import com.cayman.gankdemo.MyApp;
import com.cayman.gankdemo.module.ActivityModule;
import com.cayman.gankdemo.presenter.MainPresenter;

import javax.inject.Inject;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseContract.BaseView{

    protected BaseActivity mActivity;
//    protected  T mPresenter;

    protected ActivityComponent mComponent;

    @Nullable
    @Inject
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mActivity = this;
//        initPresenter();
        initActivityComponent();
        initInjector();
        attachView();
        initData();
    }

//    protected abstract void initPresenter();
    protected abstract void initInjector();


    protected abstract int getLayoutId();

    protected abstract void initData();


    private void initActivityComponent() {
        mComponent = DaggerActivityComponent.builder()
                .appComponent(MyApp.getInstance().getAppComponent())
                .activityModule(new ActivityModule(this))
                .build();
    }

    protected void attachView() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
    }

}
