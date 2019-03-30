package com.onexzgj.module.live.net;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by OneXzgj on 2018/4/3:09:56.
 * des:网络请求接口
 */

public interface ApiService {

//    /**
//     * 获取文章列表的操作
//     * http://www.wanandroid.com/article/list/0/json
//     *
//     * @param page 页码，拼接在连接中，从0开始。
//     * @return
//     */
//    @GET("/article/list/{page}/json")
//    Observable<DataResponse<Article>> getHomeArticles(@Path("page") int page);
//
//
//    /**
//     * 获取首页的Banner的操作
//     * http://www.wanandroid.com/banner/json
//     *
//     * @return
//     */
//    @GET("/banner/json")
//    Observable<DataResponse<List<BannerData>>> getHomeBanners();
//
//
//    /**
//     * 收藏站内文章
//     * http://www.wanandroid.com/lg/collect/1165/json
//     *
//     * @param id 文章的id
//     * @return
//     */
//    @POST("/lg/collect/{id}/json")
//    Observable<DataResponse> collectArticle(@Path("id") int id);
//
//
//    /**
//     * 删除收藏文章
//     *
//     * @param id       文章id
//     * @param originId 列表页下发，无则为-1
//     * @return Deferred<DataResponse>
//     */
//    @POST("/lg/uncollect/{id}/json")
//    @FormUrlEncoded
//    Observable<DataResponse> removeCollectArticle(@Path("id") int id, @Field("originId") int originId);
//
//
//    /**
//     * 登录接口
//     * http://www.wanandroid.com/user/login
//     *
//     * @param username 用户名
//     * @param password 密码
//     * @return
//     */
//    @POST("/user/login")
//    @FormUrlEncoded
//    Observable<DataResponse<User>> login(@Field("username") String username, @Field("password") String password);
//
//
//    /**
//     * 注册用户的方法
//     * http://www.wanandroid.com/user/register
//     *
//     * @param username   用户名
//     * @param password   密码
//     * @param repassword 确认密码
//     * @return
//     */
//    @POST("/user/register")
//    Observable<DataResponse> register(@Field("username") String username, @Field("password") String password, @Field("repassword") String repassword);
//
//
//    /**
//     * 体系结构
//     * http://www.wanandroid.com/tree/json
//     */
//
//    @GET("/tree/json")
//    Observable<DataResponse<List<KnowledgeSystem>>> getKnowledgeSystemTree();
//
//    /**
//     * 体系结构下面的文章
//     * http://www.wanandroid.com/article/list/0/json?cid=60
//     */
//
//    @GET("/article/list/{page}/json")
//    Observable<DataResponse<ArticleTypeContent>> getArticleTypeContent(@Path("page") int page, @Query("cid") int cid);
//
//
//    /**
//     * 导航数据页面
//     * http://www.wanandroid.com/navi/json
//     */
//    @GET("/navi/json")
//    Observable<DataResponse<List<Navigation>>> getNavigationContent();
//
//
//    /**
//     * 项目分类
//     * http://www.wanandroid.com/project/tree/json
//     */
//    @GET("/project/tree/json")
//    Observable<DataResponse<List<Project>>> getProjectData();
//
//
//    /**
//     * http://www.wanandroid.com/project/list/1/json?cid=294
//     * 项目分类中的详细数据列表
//     */
//    @GET("/project/list/{page}/json")
//    Observable<DataResponse<ProjectDetail>> getProjectDetailInfo(@Path("page") int page, @Query("cid") int cid);
//
//
//    /**
//     * 热搜api
//     * http://www.wanandroid.com//hotkey/json
//     */
//    @GET("/hotkey/json")
//    Observable<DataResponse<List<HotKey>>> getHotKey();
//
//    /**
//     * 常用网站
//     * http://www.wanandroid.com/friend/json
//     */
//    @GET("/friend/json")
//    Observable<DataResponse<List<Friend>>> getFriendLink();
//
//
//    /**
//     * 搜索页面
//     * http://www.wanandroid.com/article/query/0/json
//     * 页码：拼接在链接上，从0开始。
//     k ： 搜索关键词
//     */
//    @POST("article/query/{page}/json")
//    @FormUrlEncoded
//    Observable<DataResponse<Article>> getSearchArticles(@Path("page") int page, @Field("k") String key);
//

}
