package com.uhf.handsetapp.framework.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.uhf.handsetapp.framework.presenter.impl.MvpBasePresenter;

/**
 * explain:
 * Describe：
 * wx
 * 2017/7/19 17:42
 * Good Luck
 */

public abstract class BaseFragment<P extends MvpBasePresenter> extends Fragment implements FragmentView {

    protected P presenter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = bindPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null) {
            presenter.detachView();
        }
    }

    protected abstract P bindPresenter();


}
