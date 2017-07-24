package com.hb.ex01.a0612_noti;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by HB04-03 on 2017-06-12.
 */

public class Ex01 extends Activity{
    Timer timer;
    int count;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01);
        timer = new Timer();
        count = 0;

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        // notification 서비스 호출
                        notiCall();
                    }
                };
                timer.schedule(task,1000);  // 1초 후 실행
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                notificationManager.cancel(0);
            }
        });
    }
    public void notiCall(){
        // 알림(notification)
        NotificationManager notiManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder noti = new Notification.Builder(this);

        // PendingIntent : activity, broadcastreceiver, service, provider
        // 각 컴포넌트 간 호출/연결시 사용하는 intent이다.
        PendingIntent pIntent = PendingIntent.getActivity(this,1,new Intent(),0);

        noti.setTicker("문자가 수신되었습니다.");
        noti.setSmallIcon(R.mipmap.ic_launcher);
        noti.setNumber(++count);
        noti.setContentText("메시지 수신");
        noti.setContentIntent(pIntent);

        // 매니저를 이용해 noti 생성
        notiManager.notify(0,noti.build());
    }
}
