package com.onexzgj.module.live;

import android.app.Application;

import com.onexzgj.onexlibrary.GlobalApplication;
import com.onexzgj.onexlibrary.lib.IAppComponent;
import com.onexzgj.onexlibrary.lib.ServiceFactory;

/**
 * des：
 * author：onexzgj
 * time：2019/3/24
 */
public class LiveApp extends GlobalApplication implements IAppComponent{

    private Application instance;

    @Override
    public void onCreate() {
        super.onCreate();
        initlize(this);
    }


    @Override
    public void initlize(Application app) {
        instance=app;

    }
}
