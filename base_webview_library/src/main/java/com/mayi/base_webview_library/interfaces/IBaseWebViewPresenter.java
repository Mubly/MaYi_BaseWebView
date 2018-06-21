package com.mayi.base_webview_library.interfaces;

import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import java.util.Map;

/**
 * Created by Hezier on 2018/4/19.
 */

public interface IBaseWebViewPresenter {
    void instance(LinearLayout view);

    void loadUrl(String url);

    void loadUrl(String url, Map<String, String> map);

    void setWebViewClient(WebViewClient webViewClient);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setHyBirds(Object androidForJs,String key);
}
