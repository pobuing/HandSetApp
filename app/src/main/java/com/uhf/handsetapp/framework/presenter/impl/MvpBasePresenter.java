package com.uhf.handsetapp.framework.presenter.impl;

import com.uhf.handsetapp.framework.MvpView;
import com.uhf.handsetapp.framework.presenter.MvpPresenter;

/**
 * explain: 框架Presenter 基础实现类
 * Describe：
 * wx
 * 2017/7/19 17:29
 * Good Luck
 */

public abstract class MvpBasePresenter<V extends MvpView> implements MvpPresenter<V> {


    protected V view;

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        if (view != null) {
            view = null;
        }
    }

    /**
     * 界面初始化部分
     */

    public void pageInit() {
        view.initView();
        view.initData();
        view.initListener();
    }
}
