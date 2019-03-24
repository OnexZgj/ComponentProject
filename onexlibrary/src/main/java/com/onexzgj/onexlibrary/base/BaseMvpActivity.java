package com.onexzgj.onexlibrary.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.WindowManager;

import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.onexzgj.onexlibrary.constant.Constant;
import com.onexzgj.onexlibrary.constant.LoadType;
import com.onexzgj.onexlibrary.widget.LoadingDialog;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BaseMvpActivity<T extends BaseContract.BasePresenter> extends RxAppCompatActivity implements BaseContract.BaseView {


    protected Application mApplication;

    protected Context mContext;
    private int mColor;

    protected T mPresenter;
    private static final List<Activity> all_activity = new ArrayList<>();

    private LoadingDialog mLoadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
        }
//        mColor=0xff0000;
//        BarUtils.setStatusBarColor(this,mColor);


        if (mLoadingDialog==null) {
            mLoadingDialog = new LoadingDialog(this);
        }

        mPresenter = (T) initPresenter();

        attachView();

        initView();

        initData();
        mApplication = getApplication();
        mContext = this;
        if (!NetworkUtils.isConnected()) showNoNet();

        all_activity.add(this);

    }

    protected abstract BaseContract.BasePresenter initPresenter();


    private void attachView() {
        if (mPresenter != null)
            mPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        all_activity.remove(this);
        if (mPresenter != null)
            mPresenter.detachView();
    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract int getLayoutId();

    @Override
    public void showLoading(String msg) {


        //消除dialog弹出后背景变暗
//        mLoadingDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND | WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        mLoadingDialog.setCancelable(false);
        mLoadingDialog.setCanceledOnTouchOutside(false);
        mLoadingDialog.show();
        mLoadingDialog.setMessage(msg);


    }


    @Override
    public void hideLoading() {

        if (mLoadingDialog!=null){
            mLoadingDialog.dismiss();
        }
    }


    @Override
    public void showNoNet() {
        ToastUtils.showShort("404 ERROR");

        //动态添加上网络错误的view
        //添加上错误view的点击事件

    }

    @Override
    public void showToast(String msg) {
        ToastUtils.showShort(msg);
    }


    /**
     * 跳转指定的activity
     */
    public void startActivity(Class<? extends Activity> cls) {
        startActivity(new Intent(this, cls));
    }


    @Override
    public <T> LifecycleTransformer<T> bindToLife() {
        return this.bindToLifecycle();
    }

    /**
     * 结束所有的activity
     */
    public static void finishAllActivity() {
        if (all_activity == null)
            return;
        Collections.reverse(all_activity);
        for (Activity activity : all_activity) {
            if (activity != null)
                activity.finish();
        }
        all_activity.clear();
    }


    /**
     * 设置加载数据结果
     *
     * @param baseQuickAdapter
     * @param refreshLayout
     * @param list
     * @param loadType
     */
    protected void setLoadDataResult(BaseQuickAdapter baseQuickAdapter, SwipeRefreshLayout refreshLayout, List list, @LoadType.checker int loadType) {
        switch (loadType) {
            case LoadType.TYPE_REFRESH_SUCCESS:
                baseQuickAdapter.setNewData(list);
                refreshLayout.setRefreshing(false);
                break;
            case LoadType.TYPE_REFRESH_ERROR:
                refreshLayout.setRefreshing(false);
                break;
            case LoadType.TYPE_LOAD_MORE_SUCCESS:
                if (list != null) baseQuickAdapter.addData(list);
                break;
            case LoadType.TYPE_LOAD_MORE_ERROR:
                baseQuickAdapter.loadMoreFail();
                break;
        }
        if (list == null || list.isEmpty() || list.size() < Constant.PAGE_SIZE) {
            baseQuickAdapter.loadMoreEnd(false);
        } else {
            baseQuickAdapter.loadMoreComplete();
        }
    }



}
