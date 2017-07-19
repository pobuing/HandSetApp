package com.uhf.handsetapp.di.module;

import android.content.Context;

import com.uhf.handsetapp.AppBaseApplication;
import com.uhf.handsetapp.di.scope.ContextLife;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * explain:App Module 依赖注入
 * Describe：
 * wx
 * 2017/7/19 18:08
 * Good Luck
 */

@Module
public class AppModule {
    public AppBaseApplication mApplication;

    public AppModule(AppBaseApplication mApplication) {
        this.mApplication = mApplication;
    }

    @Singleton
    @Provides
    @ContextLife("Application")
    public Context provideApplicationContext() {
        return mApplication;
    }

    // TODO: other objects


}
