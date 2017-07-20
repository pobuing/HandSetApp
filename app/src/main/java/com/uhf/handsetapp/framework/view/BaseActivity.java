package com.uhf.handsetapp.framework.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.uhf.handsetapp.AppBaseApplication;
import com.uhf.handsetapp.di.component.ActivityComponet;
import com.uhf.handsetapp.di.component.ApplicationComponet;
import com.uhf.handsetapp.di.component.DaggerActivityComponet;
import com.uhf.handsetapp.di.module.ActivityModule;
import com.uhf.handsetapp.framework.presenter.impl.BasePresenter;

import butterknife.ButterKnife;

/**
 * explain: 框架 基类Activity
 * Describe：
 * wx
 * 2017/7/19 17:32
 * Good Luck
 */

public abstract class BaseActivity<P extends BasePresenter> extends Activity implements ActivityView {

    public ActivityComponet mActivityComponent;
    protected P presenter;
    protected Context context;
    private View contentView;
    private ProgressDialog progressDialog;
    private ApplicationComponet applicationComponet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        applicationComponet = ((AppBaseApplication) getApplication()).getApplicationComponet();
        mActivityComponent = DaggerActivityComponet.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponet(applicationComponet).build();
        context = applicationComponet.getApplicationContext();
        initDagger();
        initPresenter();
        contentView = getLayoutInflater().inflate(loadViewLayout(), null);
        setContentView(contentView);
        ButterKnife.bind(this);
        presenter.pageInit();
    }

    protected abstract int loadViewLayout();

    /**
     * 初始化Presenter
     */
    private void initPresenter() {
        presenter = bindPresenter();
        if (presenter != null) {
            // TODO: 视图绑定
            presenter.attachView(this);
        }
    }

    protected abstract void initDagger();


    /**
     * 绑定Presenter
     *
     * @return
     */
    protected abstract P bindPresenter();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            // TODO: 视图解绑
            presenter.detachView();
        }
    }


}
