package com.hb.ex01.a0620_vibrator;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by HB04-03 on 2017-06-20.
 */

public class VibratorActivity extends Activity{
    Button btn_once,btn_rotate,btn_cancel;
    Vibrator vibrator;

    // 진동 : 시스템에서 제공하는 서비스
    // vibrator(long milli)
    // vibrator(long[] pattern,int repeat)
    // pattern : 짝수는 진동시간, 홀수는 대기시간
    // repeat : 0이면 반복, -1이면 반복X
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vibrator);
        btn_once = (Button)findViewById(R.id.btn_once);
        btn_rotate = (Button)findViewById(R.id.btn_rotate);
        btn_cancel = (Button)findViewById(R.id.btn_cancel);

        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

        btn_once.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(2000);
            }
        });
        btn_rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(new long[] {1000,200},0);
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.cancel();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        vibrator.cancel();
    }
}
