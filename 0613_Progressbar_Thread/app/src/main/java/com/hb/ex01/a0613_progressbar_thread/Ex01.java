package com.hb.ex01.a0613_progressbar_thread;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by HB04-03 on 2017-06-13.
 */

public class Ex01 extends Activity{
    TextView tv1,tv2;
    ProgressBar pb;
    SeekBar sb;
    Handler handler;
    int i,j;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01);

        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        pb = (ProgressBar)findViewById(R.id.pb);
        sb = (SeekBar)findViewById(R.id.sb);
        handler = new Handler();

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(){
                    @Override
                    public void run() {
                        for(i=pb.getProgress();i<100;i=i+2){
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    pb.setProgress(pb.getProgress()+i);
                                    tv1.setText("진행률 : "+i+"%");
                                }
                            });
                            SystemClock.sleep(1000);
                        }
                    }
                }.start();
                new Thread(){
                    @Override
                    public void run() {
                        for(j=sb.getProgress();j<100;j=j+1){
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    sb.setProgress(sb.getProgress()+j);
                                    tv2.setText("진행률 : "+j+"%");
                                }
                            });
                            SystemClock.sleep(1000);
                        }
                    }
                }.start();
            }
        });
    }
}
