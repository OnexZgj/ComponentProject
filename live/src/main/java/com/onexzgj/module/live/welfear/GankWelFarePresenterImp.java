package com.onexzgj.module.live.welfear;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;

import com.blankj.utilcode.util.FileUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.onexzgj.module.live.net.GankioApi;
import com.onexzgj.module.live.net.RetrofitManager;
import com.onexzgj.onexlibrary.base.BasePresenter;
import com.onexzgj.onexlibrary.constant.LoadType;
import com.onexzgj.onexlibrary.utils.RxHelper;


import java.io.File;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;

/**
 * Created by OnexZgj on 2018/5/4:09:41.
 * des:
 */

public class GankWelFarePresenterImp extends BasePresenter<GankWelFareContract.View> implements GankWelFareContract.Presenter {


    private int count = 20;
    private int mPage = 1;

    /**
     * 第一次进来是刷新的逻辑
     */
    private boolean mIsRefresh = true;

    public GankWelFarePresenterImp(GankWelFareContract.View view) {
        this.mView = view;

    }

    @Override
    public void loadWelFareData() {
        RetrofitManager.createGankIo(GankioApi.class)
                .getGankIoWelfareList(count, mPage)
                .compose(mView.<GankIoWelfareListBean>bindToLife())
                .compose(RxHelper.<GankIoWelfareListBean>rxSchedulerHelper())
                .subscribe(new Consumer<GankIoWelfareListBean>() {
                    @Override
                    public void accept(GankIoWelfareListBean gankIoWelfareListBean) throws Exception {
                        int loadType = mIsRefresh ? LoadType.TYPE_REFRESH_SUCCESS : LoadType.TYPE_LOAD_MORE_SUCCESS;
                        mView.showWelFareData(gankIoWelfareListBean, loadType);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.showToast(throwable.getMessage().toString());
                    }
                });
    }

    @Override
    public void refresh() {
        mIsRefresh = true;
        mPage = 1;
        loadWelFareData();
    }

    @Override
    public void loadMore() {
        mIsRefresh = false;
        mPage++;
        loadWelFareData();
    }

    @Override
    public void saveImageToLocal(final Context context, final String imgUrl) {

        Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(ObservableEmitter<Boolean> emitter) throws Exception {
                File source = Glide.with(context).load(imgUrl).downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL).get();

                String[] split = imgUrl.split("/");
                String imageName = split[split.length - 1];


                File target = new File(Environment.getExternalStorageDirectory() + "/onexpic/" + imageName);

                boolean isSaveSuccess = FileUtils.copyFile(source, target, new FileUtils.OnReplaceListener() {
                    @Override
                    public boolean onReplace() {
                        return false;
                    }
                });

                Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                Uri uri = Uri.fromFile(target);
                intent.setData(uri);
                context.sendBroadcast(intent);

                emitter.onNext(isSaveSuccess);
            }
        }).compose(RxHelper.<Boolean>rxSchedulerHelper())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object aBoolean) throws Exception {
                        boolean isSaveSuccess = (boolean) aBoolean;
                        if (isSaveSuccess) {
                            String[] split = imgUrl.split("/");
                            String imageName = split[split.length - 1];
                            mView.showToast("图片以保存到:" + Environment.getExternalStorageDirectory() + "/onexpic/" + imageName);
                        } else {
                            mView.showToast("图片保存失败");
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.showToast(throwable.getMessage().toString());
                    }
                });
    }

}
