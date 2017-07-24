package com.hb.ex01.a0531_myapp02_progressbar;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ProgressBar;

/**
 * Created by HB04-03 on 2017-05-31.
 */

public class Ex01 extends Activity{
    ProgressBar progressBar1,progressBar2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01);

        progressBar1 = (ProgressBar)findViewById(R.id.progressBar1);
        progressBar2 = (ProgressBar)findViewById(R.id.progressBar2);

        findViewById(R.id.btn_30).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar1.setProgress(30);
            }
        });
        findViewById(R.id.btn_50).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar1.setProgress(50);
            }
        });
        findViewById(R.id.btn_100).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar1.setProgress(100);
            }
        });
    }
}
