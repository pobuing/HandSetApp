package com.uhf.handsetapp.di.module;

import android.app.Activity;

import dagger.Module;

/**
 * explain:
 * Describe：
 * wx
 * 2017/7/19 18:35
 * Good Luck
 */
@Module
public class ActivityModule {
    Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

}
