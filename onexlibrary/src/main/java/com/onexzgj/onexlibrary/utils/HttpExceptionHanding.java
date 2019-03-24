package com.onexzgj.onexlibrary.utils;

import android.net.ParseException;

import com.blankj.utilcode.util.NetworkUtils;
import com.google.gson.JsonParseException;
import com.onexzgj.onexlibrary.base.BaseContract;

import org.json.JSONException;

import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import retrofit2.HttpException;

/**
 * author：lubodada
 * data：2019/3/19
 *
 * 异常处理类
 */

public class HttpExceptionHanding {

    private BaseContract.BaseView mView;

    public HttpExceptionHanding(BaseContract.BaseView mView) {
        this.mView = mView;
    }

    /**
     * 返回错误
     *
     * @param e
     */
    public void onError(Throwable e) {
        if (mView == null)
            return;
        if (!NetworkUtils.isConnected()) {
            onException(ExceptionReason.NETWORK_NOTAVAILABLE);
        } else if (e instanceof HttpException) {
            onException(ExceptionReason.BAD_NETWORK);
        } else if (e instanceof TimeoutException) {
            onException(ExceptionReason.NETWORK_TIMEOUT);
        } else if (e instanceof SocketTimeoutException) {
            onException(ExceptionReason.NETWORK_TIMEOUT);
        } else if (e instanceof ConnectException || e instanceof UnknownHostException) {
            onException(ExceptionReason.CONNECT_ERROR);
        } else if (e instanceof InterruptedIOException) {
            onException(ExceptionReason.CONNECT_TIMEOUT);
        } else if (e instanceof JsonParseException || e instanceof JSONException || e instanceof ParseException) {
            onException(ExceptionReason.PARSE_ERROR);
        } else if (e instanceof SocketException) {
            onException(ExceptionReason.SOCKET_ERROR);
        }else {
            onException(ExceptionReason.UNKNOWN_ERROR);
        }
    }

    /**
     * 请求异常
     *
     * @param reason
     */
    public void onException(ExceptionReason reason) {
        switch (reason) {
            case NETWORK_NOTAVAILABLE:
                mView.showToast("网络不可用，请检查网络！");
                break;

            case CONNECT_ERROR:
                mView.showToast("连接错误，请重试！");
                break;

            case CONNECT_TIMEOUT:
                mView.showToast("连接超时，请重试！");
                break;

            case BAD_NETWORK:
                mView.showToast("网络异常，请检查网络状态！");
                break;

            case PARSE_ERROR:
                mView.showToast("解析数据失败，请重试");
                break;

            case NETWORK_TIMEOUT:
                mView.showToast("网络请求超时，请检查网络后重试！");
                break;
            case SOCKET_TIMEOUT:
                mView.showToast("服务器响应超时，请检查网络后重试！");
                break;
            case SOCKET_ERROR:
                mView.showToast("服务器响应异常，请检稍后重试！");
                break;
            case UNKNOWN_ERROR:
            default:
                mView.showToast("服务器响应异常，请检查网络后重试！");
                break;
        }
    }

    /**
     * 请求网络失败原因
     */
    public enum ExceptionReason {
        /**
         * 解析数据失败
         */
        PARSE_ERROR,
        /**
         * 网络不可用
         */
        NETWORK_NOTAVAILABLE,
        /**
         * 网络问题
         */
        BAD_NETWORK,
        /**
         * 连接错误
         */
        CONNECT_ERROR,
        /**
         * 连接超时
         */
        CONNECT_TIMEOUT,
        /**
         * 未知错误
         */
        UNKNOWN_ERROR,
        /**
         * 服务器返回错误
         */
        RESULT_ERROR,
        /**
         * 网络超时
         */
        NETWORK_TIMEOUT,
        /**
         * 服务器超时
         */
        SOCKET_TIMEOUT,
        /**
         * 服务器异常
         */
        SOCKET_ERROR,
    }
}
