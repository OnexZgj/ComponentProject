package com.onexzgj.onexlibrary.lib;

import android.app.Application;

/**
 * des：
 * author：onexzgj
 * time：2019/3/24
 */
public interface IAppComponent {

    String[] compoment=new String[]{
//        "com.onexzgj.module.live.LiveApp",
            "com.onexzgj.module.login.LoginApp"
    };

    void initlize(Application app);
}
