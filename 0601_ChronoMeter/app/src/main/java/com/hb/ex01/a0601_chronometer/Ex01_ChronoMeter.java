package com.hb.ex01.a0601_chronometer;

import android.app.Activity;
import android.icu.util.TimeZone;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextClock;

/**
 * Created by HB04-03 on 2017-06-01.
 */

public class Ex01_ChronoMeter extends Activity{
    Chronometer chMeter;
    TextClock textClock;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01_chronometer);

        chMeter = (Chronometer)findViewById(R.id.chMeter);
        textClock = (TextClock)findViewById(R.id.textClock);

        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chMeter.setBase(SystemClock.elapsedRealtime());
                chMeter.start();
            }
        });

        findViewById(R.id.btn_stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chMeter.stop();
            }
        });
    }
}
