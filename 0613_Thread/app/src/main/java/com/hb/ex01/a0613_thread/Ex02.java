package com.hb.ex01.a0613_thread;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

/**
 * Created by HB04-03 on 2017-06-13.
 */

public class Ex02 extends Activity{
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
                // 안드로이드 쓰레드에서는 자바처럼 뷰에 직접 값을 전달할 수 없다.
                // 안드로이드에서는 핸들러를 이용해야 한다.
                tCount++;
                handler.sendEmptyMessage(0);
                SystemClock.sleep(1000);
            }
        }
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==0){
                tv2.setText("tCount : "+tCount);
            }
        }
    };
}
