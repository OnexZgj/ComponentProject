package com.onexzgj.module.live.welfear;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.onexzgj.module.live.R;
import com.onexzgj.onexlibrary.base.BaseFragment;



/**
 * Created by OnexZgj on 2018/5/3:17:15.
 * des:干货福利Fragment
 */

public class GankWelFareFragment extends BaseFragment<GankWelFarePresenterImp> implements GankWelFareContract.View, BaseQuickAdapter.OnItemClickListener, BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.OnItemLongClickListener {



    WelFareAdapter mAdapter;

    /**
     * 请求回来的数据
     */
    private GankIoWelfareListBean mData;
    private SwipeRefreshLayout srlFgiwWelfare;
    private RecyclerView rvGankioWelfare;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gank_io_welfare;
    }


    @Override
    protected void initView(View view) {

        rvGankioWelfare = view.findViewById(R.id.rv_gankio_welfare);
        srlFgiwWelfare = view.findViewById(R.id.srl_fgiw_welfare);

        srlFgiwWelfare.setOnRefreshListener(this);

//        rvGankioWelfare.setLayoutManager(new LinearLayoutManager(getParentFragment().getContext()));

        rvGankioWelfare.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        mAdapter=new WelFareAdapter();
        mAdapter.setOnItemClickListener(this);
        mAdapter.setOnItemLongClickListener(this);
        mAdapter.setOnLoadMoreListener(this, rvGankioWelfare);
        rvGankioWelfare.setAdapter(mAdapter);
        mPresenter.loadWelFareData();
    }

    @Override
    protected GankWelFarePresenterImp initPresenter() {
        return new GankWelFarePresenterImp(this);
    }


    @Override
    public void showWelFareData(GankIoWelfareListBean data, int loadType) {
        this.mData = data;
        setLoadDataResult(mAdapter, srlFgiwWelfare, data.getResults(), loadType);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        ARouter.getInstance().build("/gank/GankWelfearLookActivity")
                .withString("url",mData.getResults().get(position).getUrl())
                .navigation();


    }

    @Override
    public void onLoadMoreRequested() {
        mPresenter.loadMore();
    }

    @Override
    public void onRefresh() {
        mPresenter.refresh();
    }

    public static GankWelFareFragment getInstance() {
        return new GankWelFareFragment();
    }

    @Override
    public boolean onItemLongClick(BaseQuickAdapter adapter, View view, final int position) {

        mPresenter.saveImageToLocal(getContext(),mData.getResults().get(position).getUrl());

        return false;
    }
}
