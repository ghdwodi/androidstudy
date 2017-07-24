package com.hb.ex01.a0613_alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by HB04-03 on 2017-06-13.
 */

public class Ex03 extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "여러번알람", Toast.LENGTH_SHORT).show();
    }
}
