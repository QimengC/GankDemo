package com.cayman.gankdemo.view;

import android.widget.TextView;

import com.cayman.gankdemo.base.BaseActivity;
import com.cayman.gankdemo.R;
import com.cayman.gankdemo.bean.GankBean;
import com.cayman.gankdemo.contract.MainContract;
import com.cayman.gankdemo.presenter.MainPresenter;

import java.util.List;


public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View{

    private TextView tvRes;

    @Override
    protected void initInjector() {
        mComponent.inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        tvRes =  findViewById(R.id.tv_result);
        mPresenter.getData(10,1);
    }

    @Override
    public void showLoading() {
        tvRes.setText("正在加载数据...");
    }

    @Override
    public void showSuccess(List<GankBean.ResultsBean> list) {
        tvRes.setText("获取数据成功,有" + list.size() +"个数据");
    }

    @Override
    public void showFaild() {
        tvRes.setText("获取数据失败");
    }
}
