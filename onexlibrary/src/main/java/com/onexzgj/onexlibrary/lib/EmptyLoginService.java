package com.onexzgj.onexlibrary.lib;

import android.content.Context;

/**
 * des：
 * author：onexzgj
 * time：2019/3/24
 */
public class EmptyLoginService implements IloginService {
    @Override
    public void launch(Context context, String targetClass) {

    }

    @Override
    public int getUserId() {
        return 0;
    }
}
