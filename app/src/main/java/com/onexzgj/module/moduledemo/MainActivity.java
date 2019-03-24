package com.onexzgj.module.moduledemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.onexzgj.module.login.LoginService;
import com.onexzgj.onexlibrary.lib.ServiceFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//                ServiceFactory.getInstance().setIloginService(new LoginService());
                ServiceFactory.getInstance().getIloginService().launch(MainActivity.this,"");
            }
        });



    }
}
