package com.onexzgj.module.moduledemo;

import android.app.Application;

import com.onexzgj.module.login.LoginApp;
import com.onexzgj.onexlibrary.GlobalApplication;
import com.onexzgj.onexlibrary.lib.IAppComponent;
import com.onexzgj.onexlibrary.lib.ServiceFactory;

/**
 * des：
 * author：onexzgj
 * time：2019/3/24
 */
public class App extends GlobalApplication implements IAppComponent {
    @Override
    public void onCreate() {
        super.onCreate();

        LoginApp app=new LoginApp();

        try {
            Class<?> aClass = Class.forName("com.onexzgj.module.login.LoginApp");
            Object o = aClass.newInstance();

        }catch (Exception e){
            e.printStackTrace();
        }

//        app.initlize(this);

        initlize(this);
//        ServiceFactory.getInstance().setIloginService(new com.onexzgj.module.login.LoginService());
    }

    @Override
    public void initlize(Application app) {

        try {
            for (String com : compoment) {
                Class<?> clazz = Class.forName(com);
                Object o = clazz.newInstance();
                if (o instanceof IAppComponent){
                    ((IAppComponent)o).initlize(app);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
