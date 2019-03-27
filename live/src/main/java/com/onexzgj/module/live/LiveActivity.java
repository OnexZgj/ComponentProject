package com.onexzgj.module.live;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/live/livemodule/liveActivity")
public class LiveActivity extends AppCompatActivity {


    @Autowired
    public String onex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live);
        ARouter.getInstance().inject(this);


        TextView tvShow = findViewById(R.id.tv_al_show);
        if (null != onex)
            tvShow.setText(onex);

    }
}
