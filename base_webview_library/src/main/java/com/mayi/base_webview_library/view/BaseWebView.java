package com.mayi.base_webview_library.view;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.mayi.base_webview_library.R;
import com.mayi.base_webview_library.interfaces.IBaseWebViewPresenter;

import java.io.File;
import java.util.Map;

public class BaseWebView extends AppCompatActivity implements IBaseWebViewPresenter {
    private WebView mWebView;
    private WebSettings webSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void instance(LinearLayout view) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mWebView = new WebView(getApplicationContext());
        webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);//访问的页面与Javascript交互
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        webSettings.setAllowFileAccess(true); //设置可以访问文件
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片

        //设置优先使用缓存:
        //缓存模式如下：
        //LOAD_CACHE_ONLY: 不使用网络，只读取本地缓存数据
        //LOAD_DEFAULT: （默认）根据cache-control决定是否从网络上取数据。
        //LOAD_NO_CACHE: 不使用缓存，只从网络获取数据.
        //LOAD_CACHE_ELSE_NETWORK，只要本地有，无论是否过期，或者no-cache，都使用缓存中的数据。
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        mWebView.setLayoutParams(params);
        ((LinearLayout) view).addView(mWebView);
    }

    @Override
    public void loadUrl(String url) {
        mWebView.loadUrl(url);
    }

    @Override
    public void loadUrl(String url, Map<String, String> map) {
        mWebView.loadUrl(url,map);
    }

    @Override
    public void setWebViewClient(WebViewClient webViewClient) {
        if (webViewClient!=null){
            mWebView.setWebViewClient(webViewClient);
        }

    }

    @Override
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        if (webChromeClient!=null){
            mWebView.setWebChromeClient(webChromeClient);
        }
    }


    @SuppressLint("JavascriptInterface")
    @Override
    public void setHyBirds(Object androidForJs, String key) {
        //        方法交互
        mWebView.addJavascriptInterface(androidForJs, key);
    }
    @Override
    protected void onResume() {
        super.onResume();
        webSettings.setJavaScriptEnabled(true);
    }
    @Override
    protected void onStop() {
        super.onStop();
        webSettings.setJavaScriptEnabled(false);
    }
    @Override
    protected void onDestroy() {
//        防止内存泄漏
        if (mWebView != null) {
            mWebView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            mWebView.clearHistory();

            ((ViewGroup) mWebView.getParent()).removeView(mWebView);
            mWebView.destroy();
            mWebView = null;
        }
        super.onDestroy();
    }
}
