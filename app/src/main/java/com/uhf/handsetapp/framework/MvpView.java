package com.uhf.handsetapp.framework;

/**
 * explain:
 * Describe：
 * wx
 * 2017/7/19 17:28
 * Good Luck
 */

public interface MvpView {
    /**
     * 初始化视图
     */
    void initView();

    /**
     * 初始化视图数据
     */
    void initData();

    void initListener();

}
