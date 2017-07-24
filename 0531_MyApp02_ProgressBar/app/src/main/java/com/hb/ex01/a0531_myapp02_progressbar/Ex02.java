package com.hb.ex01.a0531_myapp02_progressbar;

import android.animation.Animator;
import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ProgressBar;

/**
 * Created by HB04-03 on 2017-05-31.
 */

public class Ex02 extends Activity{
    ProgressBar pb3;
    int i=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex02);

        pb3 = (ProgressBar)findViewById(R.id.progressBar3);

        findViewById(R.id.btn_go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<101;i++){
                    pb3.setProgress(i);
                }
            }
        });
    }
}
