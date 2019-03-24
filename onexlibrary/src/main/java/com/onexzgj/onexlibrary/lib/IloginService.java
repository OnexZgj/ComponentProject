package com.onexzgj.onexlibrary.lib;

import android.content.Context;

/**
 * des：登录组件对外暴露的接口
 * author：onexzgj
 * time：2019/3/24
 */
public interface IloginService {

     void launch(Context context,String targetClass);


     int getUserId();
}
