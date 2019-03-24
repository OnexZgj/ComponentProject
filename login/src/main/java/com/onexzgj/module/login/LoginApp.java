package com.onexzgj.module.login;

import android.app.Application;

import com.onexzgj.onexlibrary.lib.IAppComponent;
import com.onexzgj.onexlibrary.lib.ServiceFactory;

/**
 * des：
 * author：onexzgj
 * time：2019/3/24
 */
public class LoginApp extends Application implements IAppComponent {

    private LoginApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        initlize(this);
    }

    @Override
    public void initlize(Application app) {

        instance=this;

        ServiceFactory.getInstance().setIloginService(new LoginService());
    }
}
