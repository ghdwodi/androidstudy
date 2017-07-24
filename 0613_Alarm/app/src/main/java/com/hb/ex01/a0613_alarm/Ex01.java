package com.hb.ex01.a0613_alarm;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.view.View;

import java.util.Calendar;

/**
 * Created by HB04-03 on 2017-06-13.
 */

public class Ex01 extends Activity{
    AlarmManager alarmManager;
    PendingIntent sender;
    Intent intent;
    Calendar calendar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01);

        alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());


        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Ex01.this,Ex02.class);
                intent.putExtra("msg","한번알람");
                sender = PendingIntent.getBroadcast(Ex01.this,10,intent,0);
                calendar.add(Calendar.SECOND,1);
                alarmManager.set(AlarmManager.RTC,calendar.getTimeInMillis(),sender);
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Ex01.this,Ex03.class);
                // 5초 간격으로 알람
                sender = PendingIntent.getBroadcast(Ex01.this,20,intent,0);
                alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime(),10000,sender);
            }
        });
        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Ex01.this,Ex03.class);
                sender = PendingIntent.getBroadcast(Ex01.this,20,intent,0);
                alarmManager.cancel(sender);
            }
        });
    }
}
