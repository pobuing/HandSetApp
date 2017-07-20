package com.uhf.handsetapp.appview.widget;

import android.app.ProgressDialog;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.Gravity;

import com.uhf.handsetapp.framework.view.BaseActivity;

import javax.inject.Inject;

/**
 * explain:提示对话框封装
 * Describe：
 * wx
 * 2017/7/20 11:52
 * Good Luck
 */

public class AlertDialogUtils {
    private ProgressDialog progressDialog;

    @Inject
    public AlertDialogUtils() {
    }

    public void showProgressDialog(@Nullable final String str, final BaseActivity activity) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if ((!activity.isFinishing()) && (progressDialog == null)) {
                    progressDialog = new ProgressDialog(activity);
                    progressDialog.setCancelable(false);
                    progressDialog.getWindow().getAttributes().gravity = Gravity.CENTER;
                }
                if (!TextUtils.isEmpty(str)) {
                    progressDialog.setMessage(str);
                } else {
                    progressDialog.setMessage("加载中");
                }
                progressDialog.show();
            }
        });
    }

    public void closeProgressDialog() {
        if (this.progressDialog != null && progressDialog.isShowing()) {
            this.progressDialog.dismiss();
        }
    }
}
