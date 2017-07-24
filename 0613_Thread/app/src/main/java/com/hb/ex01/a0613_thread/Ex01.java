package com.hb.ex01.a0613_thread;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by HB04-03 on 2017-06-13.
 */

public class Ex01 extends Activity{
    TextView tv1,tv2;
    int bCount, tCount;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01);
        bCount = 0;
        tCount = 0;
        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bCount++;
                tv1.setText("bCount : "+bCount);
                tv2.setText("tCount : "+tCount);
            }
        });

        ThreadClass tc = new ThreadClass();
        // 이하 JAVA의 방식
//      new Thread(tc).start();
//      Thread thread = new Thread(tc);
//      thread.start();

        // 데몬 스레드 : 사용자 스레드가 끝나면 메인 스레드도 자동으로 끝
        Thread thread = new Thread(tc);
        thread.setDaemon(true);
        thread.start();
    }

    class ThreadClass implements Runnable{
        @Override
        public void run() {
            while (true){
                tCount++;
                SystemClock.sleep(1000);
            }
        }
    }
}
