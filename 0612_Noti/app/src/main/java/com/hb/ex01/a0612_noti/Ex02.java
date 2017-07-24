package com.hb.ex01.a0612_noti;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.view.View;

/**
 * Created by HB04-03 on 2017-06-12.
 */

public class Ex02 extends Activity{
    int i = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex02);

        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(Ex02.this);

                // 알림에 나타나는 아이콘, 내용
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setTicker("히어로즈오브더스톰");
                builder.setContentTitle("시공조아");
                builder.setContentText("시공의 폭풍으로!");

                // 화면전환
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                PendingIntent pendingIntent = PendingIntent.getActivity(Ex02.this,1,intent,0);
                builder.setContentIntent(pendingIntent);

                // notificationManager
                NotificationManager notiManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                notiManager.notify(0,builder.build());
            }
        });
    }
}