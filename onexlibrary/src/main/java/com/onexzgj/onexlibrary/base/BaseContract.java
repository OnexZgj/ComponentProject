package com.onexzgj.onexlibrary.base;

import com.trello.rxlifecycle2.LifecycleTransformer;

/**
 * desc: basemvp contract
 * author: OnexZgj .
 * date: 2018/4/2 .
 */
public interface BaseContract {

    interface BasePresenter<T extends BaseContract.BaseView> {

        void attachView(T view);

        void detachView();
    }


    interface BaseView {

        //显示进度中
        void showLoading(String msg);

        //隐藏进度
        void hideLoading();

        //显示请求成功
        void showToast(String message);


        //显示当前网络不可用
        void showNoNet();

        //重试
        void onRetry();

        /**
         * 绑定生命周期
         *
         * @param <T>
         * @return
         */
        <T> LifecycleTransformer<T> bindToLife();

    }
}
