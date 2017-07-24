package com.hb.ex01.a0601_timepicker;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import android.widget.TimePicker;

/**
 * Created by HB04-03 on 2017-06-01.
 */

public class Ex01_TimePicker extends Activity{
    TimePicker timePicker;
    TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01_timepicker);

        TimePicker timePicker = (TimePicker)findViewById(R.id.timePicker);
        final TextView textView = (TextView)findViewById(R.id.textView);

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                textView.setText(String.format("%d시 %d분",hourOfDay,minute));
            }
        });
    }
}
