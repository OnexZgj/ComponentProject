package com.onexzgj.onexlibrary.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.onexzgj.onexlibrary.R;

import org.w3c.dom.Text;

/**
 * des：
 * author：onexzgj
 * time：2019/3/14
 */
public class LoadingDialog extends Dialog {


    private LoadingView mLoadingView;
    private final TextView tvShowMsg;
    private TextView loading_view_show;


    @Override
    public void show() {
        super.show();
        if (mLoadingView != null) {
            mLoadingView.start();
        }
    }


    public LoadingDialog(Context context) {
        super(context, R.style.dialog);
        // 加载布局
        setContentView(R.layout.loading_view);
        mLoadingView = findViewById(R.id.loading_view);
        tvShowMsg = findViewById(R.id.loading_text);
        loading_view_show = findViewById(R.id.loading_view_show);
        mLoadingView.addBitmap(R.mipmap.sjx);
        mLoadingView.addBitmap(R.mipmap.rect);
        mLoadingView.addBitmap(R.mipmap.circle);

        // 设置Dialog参数
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.CENTER;
        window.setAttributes(params);
    }

    // TODO 封装Dialog消失的回调
    @Override
    public void onBackPressed() {
        // 关闭Loading
        dismiss();
    }


    @Override
    public void dismiss() {
        super.dismiss();
        if (mLoadingView != null) {
            mLoadingView.stop();
        }
    }

    public void setMessage(String msg) {
        if (tvShowMsg != null) {
            tvShowMsg.setText(msg);
        }
        loading_view_show.setText(msg);
    }
}
