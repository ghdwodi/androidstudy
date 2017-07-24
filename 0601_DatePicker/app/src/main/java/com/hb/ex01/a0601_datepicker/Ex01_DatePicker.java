package com.hb.ex01.a0601_datepicker;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.DatePicker;
import android.widget.TextView;

/**
 * Created by HB04-03 on 2017-06-01.
 */

public class Ex01_DatePicker extends Activity{
    DatePicker dp1;
    TextView tv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01_datepicker);

        dp1 = (DatePicker)findViewById(R.id.dp1);
        tv = (TextView)findViewById(R.id.tv);

        dp1.init(dp1.getYear(), dp1.getMonth(), dp1.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//              tv.setText(year+"년 "+(monthOfYear+1)+"월 "+dayOfMonth+"일");
                tv.setText(String.format("%d년 %d월 %d일",year,monthOfYear+1,dayOfMonth));
            }
        });
    }
}
