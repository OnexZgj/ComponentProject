package com.onexzgj.onexlibrary.base;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.just.agentweb.AgentWeb;
import com.onexzgj.onexlibrary.R;
import com.onexzgj.onexlibrary.constant.Constant;

/**
 * 所有url跳转的activity
 *
 * @author onexzgj
 * @time 2017/12/12
 */
public class WebActivity extends AppCompatActivity {


    private String mUrl;
    private LinearLayout webContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_web);
        webContent = findViewById(R.id.fl_aw_container);

        if (getIntent() != null) {
            mUrl = getIntent().getStringExtra(Constant.AIM_URL);
        }else{
            throw new RuntimeException("u must add url!");
        }



        AgentWeb mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(webContent, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator(Color.GREEN)
                .createAgentWeb()
                .ready()
                .go(mUrl);
    }

}
