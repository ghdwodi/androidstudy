package com.hb.ex01.a0613_alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by HB04-03 on 2017-06-13.
 */

// BroadcastReceiver는 4대 컴포넌트 중 하나이므로 반드시 매니페스트에 등록해야 한다.

public class Ex02 extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "1회 알람", Toast.LENGTH_SHORT).show();
        String msg = intent.getStringExtra("msg");
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
