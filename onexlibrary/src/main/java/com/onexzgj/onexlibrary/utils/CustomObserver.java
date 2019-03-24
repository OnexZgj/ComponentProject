package com.onexzgj.onexlibrary.utils;

import com.onexzgj.onexlibrary.base.BaseContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * author：lubodada
 * data：2019/3/19
 * <p>
 * 自定义观察者类
 */

public abstract class CustomObserver<T> implements Observer<T> {

    private final String TAG = CustomObserver.class.getSimpleName();
    private BaseContract.BaseView mView;
    private HttpExceptionHanding httpExceptionHanding;

    public CustomObserver(){

    }

    public CustomObserver(BaseContract.BaseView view, String msg) {
        this.mView = view;
        httpExceptionHanding = new HttpExceptionHanding(mView);
        if (mView != null)
            mView.showLoading(msg);
    }


    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable e) {
        if (mView != null)
            mView.hideLoading();
        httpExceptionHanding.onError(e);
    }

    @Override
    public void onComplete() {
        if (mView != null)
            mView.hideLoading();
    }
}
