package com.onexzgj.module.live.net;


import com.onexzgj.module.live.welfear.GankIoWelfareListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Created by OnexZgj on 2018/5/3:15:25.
 * des:
 */

public interface GankioApi {

    /**
     * http://gank.io/api/day/2015/08/06
     */
    /**
     * 获取今日的推荐
     * @param year
     * @param month
     * @param day
     * @return
     */
//    @GET("api/day/{year}/{month}/{day}")
//    Observable<GankIoDayBean> getGankIoDay(@Path("year") String year, @Path("month") String month, @Path("day") String day);


    /**
     * 分类数据: http://gank.io/api/data/数据类型/请求个数/第几页
     * 数据类型： 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
     * 请求个数： 数字，大于0
     * 第几页：数字，大于0
     * eg: http://gank.io/api/data/Android/10/1
     */
//    @GET("api/data/{type}/{pre_page}/{page}")
//    Observable<GankIoCustomListBean> getGankIoCustomList(@Path("type") String type, @Path
//            ("pre_page") int
//            pre_page, @Path("page") int page);



    /**
     * 福利: http://gank.io/api/data/福利/请求个数/第几页
     * 数据类型： 福利
     * 请求个数： 数字，大于0
     * 第几页：数字，大于0
     * eg: http://gank.io/api/data/福利/10/1
     */
    @GET("api/data/福利/{pre_page}/{page}")
    Observable<GankIoWelfareListBean> getGankIoWelfareList(@Path("pre_page") int pre_page,
                                                           @Path("page") int page);


    /**
     * http://gank.io/api/day/history
     * 获取干货发布的历史日期，方便查询最近的一天
     */

//    @GET("api/day/history")
//    Observable<GankioHistory> getGankIoHistory();




}
