package com.onexzgj.onexlibrary.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.onexzgj.onexlibrary.R;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.support.RxFragment;

/**
 * author: OnexZgj
 * date: 2018/4/2 .
 */

public abstract class BaseFragment<T extends BaseContract.BasePresenter> extends RxFragment implements BaseContract.BaseView {
    private static final String STATE_SAVE_IS_HIDDEN = "STATE_SAVE_IS_HIDDEN";

    protected T mPresenter;
    private View mRootView;
    private ProgressDialog mProgressDialog;

    protected abstract int getLayoutId();


    protected abstract void initView(View view);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        attachView();
        if (!NetworkUtils.isConnected()) showNoNet();
        if (savedInstanceState != null) {
            boolean isSupportHidden = savedInstanceState.getBoolean(STATE_SAVE_IS_HIDDEN);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            if (isSupportHidden) {
                ft.hide(this);
            } else {
                ft.show(this);
            }
            ft.commit();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(STATE_SAVE_IS_HIDDEN, isHidden());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflaterView(inflater, container);

        if (mProgressDialog == null)
            mProgressDialog = new ProgressDialog(getContext(), 0);
        mPresenter= initPresenter();
        initView(mRootView);
        return mRootView;
    }

    protected abstract T initPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        detachView();
    }



    @Override
    public void showNoNet() {
        ToastUtils.showShort(R.string.no_network_connection);
    }

    @Override
    public void onRetry() {
        ToastUtils.showShort("onRetry");
    }

    @Override
    public <T> LifecycleTransformer<T> bindToLife() {
        return this.bindToLifecycle();
    }



    @Override
    public void showLoading(String msg) {
        mProgressDialog.setMessage(msg);
        mProgressDialog.setCanceledOnTouchOutside(true);
        mProgressDialog.show();
    }


    @Override
    public void hideLoading() {
        if (mProgressDialog != null)
            mProgressDialog.hide();
    }



    /**
     * 贴上view
     */
    private void attachView() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    /**
     * 分离view
     */
    private void detachView() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }


    /**
     * 设置View
     *
     * @param inflater
     * @param container
     */
    private void inflaterView(LayoutInflater inflater, @Nullable ViewGroup container) {
        if (mRootView == null) {
            mRootView = inflater.inflate(getLayoutId(), container, false);
        }
    }

    @Override
    public void showToast(String message) {
        ToastUtils.showShort(message);
    }
}
