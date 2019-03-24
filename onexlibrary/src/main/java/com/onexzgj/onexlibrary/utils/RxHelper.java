package com.onexzgj.onexlibrary.utils;


import com.onexzgj.onexlibrary.constant.Constant;
import com.onexzgj.onexlibrary.constant.LoadType;


import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by OnexZgj on 2017/9/12.
 * <p>
 */
public class RxHelper {
    /**
     * 统一线程处理
     * <p>
     * 发布事件io线程，接收事件主线程
     */
    public static <T> ObservableTransformer<T, T> rxSchedulerHelper() {//compose处理线程
        return new ObservableTransformer<T, T>() {

            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 生成Flowable
     *
     * @param t
     * @return Flowable
     */
    public static <T> Flowable<T> createFlowable(final T t) {
        return Flowable.create(new FlowableOnSubscribe<T>() {
            @Override
            public void subscribe(FlowableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(t);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        }, BackpressureStrategy.BUFFER);
    }

    /**
     * 生成Observable
     *
     * @param t
     * @return Flowable
     */
    public static <T> Observable<T> createObservable(final T t) {
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(t);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        });
    }



//     mView.showLoading("正在加载中...");
//        Observable.create(new ObservableOnSubscribe<List<T_ZJ_SBQSM_XCAZ_QXJL>>() {
//        @Override
//        public void subscribe(ObservableEmitter<List<T_ZJ_SBQSM_XCAZ_QXJL>> emitter) throws Exception {
//
//            try {
//
//                Thread.sleep(5000);
//                List<T_ZJ_SBQSM_XCAZ_QXJL> beanlist = LitePal.limit(Constant.PAGE_SIZE).offset(mIndexPage * Constant.PAGE_SIZE).find(T_ZJ_SBQSM_XCAZ_QXJL.class);
//                if (beanlist != null && beanlist.size() > 0) {
//                    emitter.onNext(beanlist);
//                } else {
//                    emitter.onNext(null);
//                }
//
//            } catch (Exception e) {
//                emitter.onError(e);
//            }
//        }
//    }).compose(mView.<List<T_ZJ_SBQSM_XCAZ_QXJL>>bindToLife())
//            .compose(RxHelper.rxSchedulerHelper())
//            .subscribe(new Consumer<Object>() {
//        @Override
//        public void accept(Object data) throws Exception {
//            if (data != null) {
//                int loadType = mIsRefreshing ? LoadType.TYPE_REFRESH_SUCCESS : LoadType.TYPE_LOAD_MORE_SUCCESS;
//
//                mView.showLocalTask((List<T_ZJ_SBQSM_XCAZ_QXJL>) data, loadType);
//            } else {
//                mView.showToast("没有更多的数据!");
//            }
//            mView.hideLoading();
//        }
//    }, new Consumer<Throwable>() {
//        @Override
//        public void accept(Throwable throwable) throws Exception {
//            mView.hideLoading();
//            mView.showToast("出错了!");
//        }
//    });



}
