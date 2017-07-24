package com.hb.ex01.a0531_myapp02_progressbar;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by HB04-03 on 2017-05-31.
 */

// 프로그레스바는 쓰레드 처리가 기본이다.
// 쓰레드 처리시 값 전달은 핸들러를 이용한다.
public class Ex04 extends Activity{
    ProgressBar pb4,pb5;
    TextView tv_percent;
    Handler handler = new Handler();
    int i=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex04);

        pb4 = (ProgressBar)findViewById(R.id.progressBar4);
        pb5 = (ProgressBar)findViewById(R.id.progressBar5);
        tv_percent = (TextView)findViewById(R.id.tv_percent);

        findViewById(R.id.btn_go2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(true){
                            if(i<100){
                                i++;
                            }else{
                                i=0;
                                break;
                            }
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    tv_percent.setText(String.valueOf(i)+"%");
                                    pb4.setProgress(i);
                                    pb5.setProgress(i);
                                }
                            });
                            SystemClock.sleep(500);
                        }
                    }
                }).start();
            }
        });
    }
}
