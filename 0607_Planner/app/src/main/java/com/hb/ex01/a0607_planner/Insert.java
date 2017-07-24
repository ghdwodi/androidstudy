package com.hb.ex01.a0607_planner;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by HB04-03 on 2017-06-07.
 */

public class Insert extends Activity{
    EditText et_content;
    DatePicker datePicker;
    String datefile;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insertpage);
        datePicker = (DatePicker)findViewById(R.id.datePicker);
        et_content = (EditText)findViewById(R.id.et_content);
        // 오늘 날짜
        int mYear = Calendar.getInstance().get(Calendar.YEAR);
        int mMonth = Calendar.getInstance().get(Calendar.MONTH);
        int mDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        String monthStr = String.valueOf(mMonth+1);
        String dayStr = String.valueOf(mDay);
        if((mMonth+1)<10){
            monthStr = "0"+monthStr;
        }
        if(mDay<10){
            dayStr = "0"+dayStr;
        }

        datefile = mYear+"년 "+monthStr+"월 "+dayStr+"일";

        datePicker.init(mYear, mMonth, mDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String monthOfYearStr = String.valueOf(monthOfYear+1);
                String dayOfMonthStr = String.valueOf(dayOfMonth);
                if((monthOfYear+1)<10){
                    monthOfYearStr = "0"+monthOfYearStr;
                }
                if(dayOfMonth<10){
                    dayOfMonthStr = "0"+dayOfMonthStr;
                }
                datefile = year+"년 "+monthOfYearStr+"월 "+dayOfMonthStr+"일";
            }
        });


        findViewById(R.id.btn_insert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_content.getText().toString().length()==0){
                    Toast.makeText(Insert.this, "일정을 입력하세요!", Toast.LENGTH_SHORT).show();
                }else {
                    DAOmethods helper = new DAOmethods(Insert.this);
                    if(helper.dateChk(datefile)){
                        Toast.makeText(Insert.this, "일정이 이미 있습니다.", Toast.LENGTH_SHORT).show();
                    }else{
                        helper.insertPlan(datefile,et_content.getText().toString().trim());
                        Toast.makeText(Insert.this, "입력 성공!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });

        findViewById(R.id.btn_maingo1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
