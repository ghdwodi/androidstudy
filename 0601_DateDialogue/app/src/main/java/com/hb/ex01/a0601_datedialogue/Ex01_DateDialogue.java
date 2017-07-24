package com.hb.ex01.a0601_datedialogue;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by HB04-03 on 2017-06-01.
 */

public class Ex01_DateDialogue extends Activity{
    TextView tv1;
    int mYear,mMonth,mDay,mHour,mMinute;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01_datedialogue);

        tv1 = (TextView)findViewById(R.id.tv1);

        Calendar now = Calendar.getInstance();
        mYear = now.get(Calendar.YEAR);
        mMonth = now.get(Calendar.MONTH);
        mDay = now.get(Calendar.DAY_OF_MONTH);
        mHour = now.get(Calendar.HOUR);
        mMinute = now.get(Calendar.MINUTE);



        findViewById(R.id.btn_date).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Ex01_DateDialogue.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        mYear = year;
                        mMonth = month;
                        mDay = dayOfMonth;
                        tv1.setText(String.format("%d. %d. %d. %d:%d",mYear,mMonth+1,mDay,mHour,mMinute));
                    }
                },mYear,mMonth,mDay).show();
            }
        });
        findViewById(R.id.btn_time).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(Ex01_DateDialogue.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        mHour = hourOfDay;
                        mMinute = minute;
                        tv1.setText(String.format("%d. %d. %d. %d:%d",mYear,mMonth+1,mDay,mHour,mMinute));
                    }
                },mHour,mMinute,false).show();
            }
        });
    }

    private Dialog createDialog(int id){

        return null;
    }
}
