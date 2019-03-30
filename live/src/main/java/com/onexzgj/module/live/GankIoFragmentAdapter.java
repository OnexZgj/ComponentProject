package com.onexzgj.module.live;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.onexzgj.onexlibrary.base.BaseFragment;

import java.util.List;


/**
 * Created by Linsa on 2018/5/3:16:26.
 * des:
 */

public class GankIoFragmentAdapter extends FragmentStatePagerAdapter {

    private List<BaseFragment> mFragments;

    private String[] titles=new String[]{"福利"};

    public GankIoFragmentAdapter(FragmentManager fm, List<BaseFragment> fragments) {
        super(fm);
        this.mFragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
