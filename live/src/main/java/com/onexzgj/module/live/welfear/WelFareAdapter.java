package com.onexzgj.module.live.welfear;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.onexzgj.module.live.R;


import javax.inject.Inject;


/**
 * Created by OnexZgj on 2018/5/4:10:03.
 * des:
 */

public class WelFareAdapter extends BaseQuickAdapter<GankIoWelfareListBean.ResultsBean, BaseViewHolder> {


    @Inject
    public WelFareAdapter() {
        super(R.layout.item_welfare, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, GankIoWelfareListBean.ResultsBean item) {

//        Glide.with(App.getAppContext())
//                .load(R.mipmap.img_default_meizi)
//                .into((ImageView) helper.getView(R.id.iv_item_image));

        Glide.with(mContext).load(item.getUrl())
                .into((ImageView) helper.getView(R.id.iv_iw_image));
    }
}
