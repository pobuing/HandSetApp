package com.uhf.handsetapp.login;

import com.uhf.handsetapp.framework.view.BaseActivity;
import com.uhf.handsetapp.handsetapp.R;

import javax.inject.Inject;

/**
 * explain:
 * Describe：
 * wx
 * 2017/7/19 17:47
 * Good Luck
 */

public class LoginActivity extends BaseActivity<LoginPresenter> {

    @Inject
    LoginPresenter loginPresenter;

    @Override
    protected int loadViewLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initDagger() {
        mActivityComponent.inject(this);
    }

    @Override
    protected LoginPresenter bindPresenter() {
        return loginPresenter;
    }
}
