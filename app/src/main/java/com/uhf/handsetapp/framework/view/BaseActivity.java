package com.uhf.handsetapp.framework.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.uhf.handsetapp.AppBaseApplication;
import com.uhf.handsetapp.di.component.ActivityComponet;
import com.uhf.handsetapp.di.component.DaggerActivityComponet;
import com.uhf.handsetapp.di.module.ActivityModule;
import com.uhf.handsetapp.framework.presenter.MvpPresenter;

/**
 * explain: 框架 基类Activity
 * Describe：
 * wx
 * 2017/7/19 17:32
 * Good Luck
 */

public abstract class BaseActivity<P extends MvpPresenter> extends Activity implements ActivityView {

    public ActivityComponet mActivityComponent;
    protected P presenter;
    private View contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = DaggerActivityComponet.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponet(((AppBaseApplication) getApplication()).getApplicationComponet()).build();
        initDagger();
        initPresenter();
        contentView = getLayoutInflater().inflate(loadViewLayout(), null);
        setContentView(contentView);
    }

    protected abstract int loadViewLayout();

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
