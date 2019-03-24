package com.onexzgj.module.login;

import android.content.Context;
import android.content.Intent;

import com.onexzgj.onexlibrary.lib.IloginService;

/**
 * des：
 * author：onexzgj
 * time：2019/3/24
 */
public class LoginService implements IloginService {

    @Override
    public void launch(Context context, String targetClass) {
        Intent intent=new Intent(context,LoginActivity.class);
        intent.putExtra("extra",targetClass);
        context.startActivity(intent);
    }

    @Override
    public int getUserId() {
        return 0;
    }
}
