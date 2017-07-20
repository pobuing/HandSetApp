package com.uhf.handsetapp.login;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.uhf.handsetapp.appview.widget.AlertDialogUtils;
import com.uhf.handsetapp.appview.widget.ResourceUtils;
import com.uhf.handsetapp.framework.view.BaseActivity;
import com.uhf.handsetapp.handsetapp.R;
import com.uhf.handsetapp.retrofit2lesson.RetrofitDemo;
import com.uhf.handsetapp.utils.ToastUtils;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * explain:
 * Describe：
 * wx
 * 2017/7/19 17:47
 * Good Luck
 */

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView, View.OnClickListener {

    @Inject
    LoginPresenter loginPresenter;
    @Inject
    AlertDialogUtils alertDialogUtils;
    @BindView(R.id.et_loginaccount)
    EditText etLoginaccount;
    @BindView(R.id.et_loginpwd)
    EditText etLoginpwd;
    @BindView(R.id.btn_login)
    Button btnLogin;
    private String inputAccount;
    private String inputPwd;


    @Override
    protected int loadViewLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initDagger() {
        mActivityComponent.inject(this);
    }

    @Override
    protected LoginPresenter bindPresenter() {
        return loginPresenter;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        btnLogin.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_login:
                inputAccount = etLoginaccount.getText().toString().trim();
                inputPwd = etLoginpwd.getText().toString().trim();
                new RetrofitDemo().prepareRequest();

                if (!TextUtils.isEmpty(inputAccount)) {
                    if (!TextUtils.isEmpty(inputPwd)) {
                        // TODO:judge login
//                        presenter.loginFunction(inputAccount,inputPwd);
                    } else {
                        ToastUtils.showMessage(context, ResourceUtils.getStringResource(context, R.string.error_login_pwd_null));
                    }
                } else {
                    ToastUtils.showMessage(context, ResourceUtils.getStringResource(context, R.string.error_login_account_null));
                }
                break;
        }
    }
}
