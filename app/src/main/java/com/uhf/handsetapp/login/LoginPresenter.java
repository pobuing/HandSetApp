package com.uhf.handsetapp.login;

import com.uhf.handsetapp.framework.model.impl.BaseModel;
import com.uhf.handsetapp.framework.presenter.impl.BasePresenter;

import javax.inject.Inject;

/**
 * explain:
 * Describe：
 * wx
 * 2017/7/19 17:54
 * Good Luck
 */

public class LoginPresenter extends BasePresenter<BaseModel> {

    @Inject
    LoginModel model;

    @Inject
    public LoginPresenter() {
        super();
    }

    @Override
    protected BaseModel bindModel() {
        return model;
    }
}
