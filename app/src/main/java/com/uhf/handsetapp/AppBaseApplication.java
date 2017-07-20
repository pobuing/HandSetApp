package com.uhf.handsetapp;

import android.app.Application;

import com.uhf.handsetapp.di.component.ApplicationComponet;
import com.uhf.handsetapp.di.component.DaggerApplicationComponet;
import com.uhf.handsetapp.di.module.AppModule;

/**
 * explain:应用程序基类
 * Describe：
 * wx
 * 2017/7/19 18:02
 * Good Luck
 */

public class AppBaseApplication extends Application {

    private ApplicationComponet mApplicationComponet;


    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponet = DaggerApplicationComponet.builder().appModule(new AppModule(this)).build();
    }

    public ApplicationComponet getApplicationComponet() {
        return mApplicationComponet;
    }

}
