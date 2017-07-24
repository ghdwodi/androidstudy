package com.hb.ex01.a0531_myapp02_progressbar;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by HB04-03 on 2017-05-31.
 */

public class Ex03 extends Activity{
    ProgressBar pb4,pb5;
    TextView tv_percent;
    int i=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex03);

        pb4 = (ProgressBar)findViewById(R.id.progressBar4);
        pb5 = (ProgressBar)findViewById(R.id.progressBar5);
        tv_percent = (TextView)findViewById(R.id.tv_percent);

        findViewById(R.id.btn_go2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i=0;i<101;i++){
                    tv_percent.setText(String.valueOf(i)+"%");
                    pb4.setProgress(i);
                    pb5.setProgress(i);
                }
            }
        });
    }
}
