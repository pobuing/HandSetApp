package com.uhf.handsetapp.di.component;

import com.uhf.handsetapp.di.module.ActivityModule;
import com.uhf.handsetapp.di.scope.ActivityScope;
import com.uhf.handsetapp.login.LoginActivity;

import dagger.Component;

/**
 * explain:
 * Describe：
 * wx
 * 2017/7/19 18:34
 * Good Luck
 */

@ActivityScope
@Component(dependencies = ApplicationComponet.class, modules = ActivityModule.class)
public interface ActivityComponet {
    //需要此对象的Activity，注入
    void inject(LoginActivity baseActivity);
}
