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
    public LoginPresenter(LoginModel model) {
        this.model = model;
    }


    /**
     * 登录方法
     *
     * @param inputAccount
     * @param inputPwd
     */
    public void loginFunction(String inputAccount, String inputPwd) {

    }
}
