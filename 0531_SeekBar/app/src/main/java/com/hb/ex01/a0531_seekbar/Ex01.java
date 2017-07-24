package com.hb.ex01.a0531_seekbar;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by HB04-03 on 2017-05-31.
 */

// SeekBar도 쓰레드 처리를 하므로 Handler 사용
public class Ex01 extends Activity{
    TextView textView2, textView4;
    SeekBar seekBar1,seekBar2;
    Handler handler = new Handler();
    int i=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01);

        textView2 = (TextView)findViewById(R.id.textView2);
        textView4 = (TextView)findViewById(R.id.textView4);
        seekBar1 = (SeekBar)findViewById(R.id.seekBar1);
        seekBar2 = (SeekBar)findViewById(R.id.seekBar2);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (i=seekBar1.getProgress();i>10;i=i+(int)(Math.random()*5)){
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    textView2.setText(seekBar1.getProgress()+"%");
                                    seekBar1.setProgress(i);
                                }
                            });
                            SystemClock.sleep(500);
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (i=seekBar1.getProgress();i>10;i=i+(int)(Math.random()*5)){
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    textView4.setText(seekBar2.getProgress()+"%");
                                    seekBar2.setProgress(i);
                                }
                            });
                            SystemClock.sleep(300);
                        }
                    }
                }).start();
            }
        });
    }
}
