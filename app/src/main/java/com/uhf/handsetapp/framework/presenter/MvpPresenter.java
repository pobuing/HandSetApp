package com.uhf.handsetapp.framework.presenter;

import com.uhf.handsetapp.framework.MvpView;

/**
 * explain: 框架 presenter
 * Describe：
 * wx
 * 2017/7/19 17:27
 * Good Luck
 */

public interface MvpPresenter<V extends MvpView> {

    /**
     * 视图绑定
     *
     * @param view
     */
    void attachView(V view);

    /**
     * 视图解绑
     */
    void detachView();

}
