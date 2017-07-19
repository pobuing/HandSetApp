package com.uhf.handsetapp.framework.presenter.impl;

import com.uhf.handsetapp.framework.model.impl.BaseModel;

/**
 * explain:
 * Describe：
 * wx
 * 2017/7/19 17:51
 * Good Luck
 */

public abstract class BasePresenter<M extends BaseModel> extends MvpBasePresenter {
    private M model;

    public BasePresenter() {
        this.model = bindModel();
    }

    protected abstract M bindModel();
}
