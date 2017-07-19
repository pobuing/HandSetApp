package com.uhf.handsetapp.di.component;

import android.content.Context;

import com.uhf.handsetapp.di.module.AppModule;
import com.uhf.handsetapp.di.scope.ContextLife;

import javax.inject.Singleton;

import dagger.Component;

/**
 * explain:
 * Describe：
 * wx
 * 2017/7/19 18:21
 * Good Luck
 */
@Singleton
@Component(modules = AppModule.class)
public interface ApplicationComponet {
    @ContextLife("Application")
    Context getApplicationContext();


}
