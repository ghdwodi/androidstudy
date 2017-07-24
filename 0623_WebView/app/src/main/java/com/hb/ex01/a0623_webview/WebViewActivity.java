package com.hb.ex01.a0623_webview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;

/**
 * Created by HB04-03 on 2017-06-23.
 */

public class WebViewActivity extends Activity{
    WebView web_view;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view);
        web_view = (WebView)findViewById(R.id.web_view);

        web_view.loadUrl("http://192.168.0.133:8090/Ex04_Web/MyController");
    }
}
