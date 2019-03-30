package com.onexzgj.module.live;

import android.support.v4.view.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.onexzgj.module.live.welfear.GankWelFareFragment;
import com.onexzgj.onexlibrary.base.BaseActivity;
import com.onexzgj.onexlibrary.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

@Route(path = "/live/livemodule/liveActivity")
public class LiveActivity extends BaseActivity {

   private List<BaseFragment> fragments=new ArrayList<>();

    private ViewPager vpLiveContent;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_live;
    }

    @Override
    protected void initView() {
        vpLiveContent = findViewById(R.id.vp_live_al_content);
    }

    @Override
    protected void initData() {


        fragments.add(GankWelFareFragment.getInstance());

        vpLiveContent.setAdapter(new GankIoFragmentAdapter(getSupportFragmentManager(),fragments));

    }
}
