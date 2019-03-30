package com.onexzgj.module.live.welfear;

import android.content.Context;

import com.onexzgj.onexlibrary.base.BaseContract;


/**
 * Created by OnexZgj on 2018/5/4:09:29.
 * des:
 */

public interface GankWelFareContract {

    interface View extends BaseContract.BaseView{
        void showWelFareData(GankIoWelfareListBean data, int loadType);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        /**
         * 加载妹子的福利
         */
        void loadWelFareData();

        void refresh();

        void loadMore();

        /** 保存图片到本地 */
        void saveImageToLocal(Context context, String imgUrl);
    }

}
