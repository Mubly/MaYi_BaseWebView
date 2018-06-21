package com.mayi.mayi_basewebview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.mayi.base_webview_library.view.BaseWebView;

public class MainActivity extends BaseWebView {
    private LinearLayout mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLayout = findViewById(R.id.main_wab_view);
        instance(mLayout);
        loadUrl("https://baidu.com/");
        setWebChromeClient(new WebChromeClient());
        setWebViewClient(new WebViewClient());
    }
}
