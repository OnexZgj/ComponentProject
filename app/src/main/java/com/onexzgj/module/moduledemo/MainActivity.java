package com.onexzgj.module.moduledemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path="/app/module/mainActivity")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ARouter.getInstance().build("/login/activity/loginActivity").navigation();
//                ServiceFactory.getInstance().setIloginService(new LoginService());
//                ServiceFactory.getInstance().getIloginService().launch(LiveActivity.this,"");
            }
        });

        Button btnTwo = findViewById(R.id.btn_two);
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/app/module/twoActivity").navigation();
            }
        });
    }

}
