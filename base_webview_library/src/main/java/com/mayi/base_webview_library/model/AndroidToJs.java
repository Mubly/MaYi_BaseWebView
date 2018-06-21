package com.mayi.base_webview_library.model;

import android.app.Activity;
import android.content.Intent;
import android.webkit.JavascriptInterface;

/**
 * Created by Hezier on 2018/2/5.
 */

public class AndroidToJs extends Object {
    private Activity activity;

    public AndroidToJs(Activity activity) {
        this.activity = activity;
    }

    @JavascriptInterface
    public void takePhotos() {
//        TakePhotos.getCamer(0,688, new CatchCamer() {
//            @Override
//            public void success(String pathUrl) {
//                ((BaseActivity) activity).photoPath = pathUrl;
////                JUtils.Toast(activity,pathUrl);
//            }
//
//            @Override
//            public void failure(String message) {
//                JUtils.Toast(activity, message);
//            }
//        }, activity);
    }

    @JavascriptInterface
    public void catchlocal() {
//        CatchLocal catchLocal = new CatchLocal(activity);
//        catchLocal.initLocal(new OneCallback() {
//            @Override
//            public void callBack(Object object) {
//                final String address = ((AMapLocation) object).getAddress();
//                activity.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        ((TaskManagerActivity) activity).getmWebView().loadUrl("javascript:Hybrid.reciveLocation('" + address + "')");
//                    }
//                });
//            }
//        });
    }
    @JavascriptInterface
    public void scanCode() {
//        Intent intent =new Intent(activity, ZXingActivity.class);
//        activity.startActivityForResult(intent,888);
    }
}
