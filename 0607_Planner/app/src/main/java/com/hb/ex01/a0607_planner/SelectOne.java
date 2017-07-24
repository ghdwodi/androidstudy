package com.hb.ex01.a0607_planner;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by HB04-03 on 2017-06-07.
 */

public class SelectOne extends Activity{
    DAOmethods helper;
    TextView tv_date2;
    EditText et_content2;
    int thisYear,thisMonth,thisDay;
    VO vo;
    String date="";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        helper = new DAOmethods(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectone);
        tv_date2 = (TextView)findViewById(R.id.tv_date2);
        et_content2 = (EditText)findViewById(R.id.et_content2);

        Calendar todaycal = Calendar.getInstance();
        thisYear = todaycal.get(Calendar.YEAR);
        thisMonth = todaycal.get(Calendar.MONTH);
        thisDay = todaycal.get(Calendar.DAY_OF_MONTH);
        String thisMonthStr = String.valueOf(thisMonth+1);
        String thisDayStr = String.valueOf(thisDay);
        if((thisMonth+1)<10){
            thisMonthStr = "0"+thisMonthStr;
        }
        if(thisDay<10){
            thisDayStr = "0"+thisDayStr;
        }
        if(getIntent().getStringExtra("date")==null){
            date = thisYear+"년 "+thisMonthStr+"월 "+thisDayStr+"일";
        }else{
            date = getIntent().getStringExtra("date");
        }

        tv_date2.setText(date);

        vo = helper.selectOnePlan(date);

        et_content2.setText(vo.getContent());

        tv_date2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(SelectOne.this,android.R.style.Theme_Holo_Light_Dialog,new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        thisYear = year;
                        thisMonth = month;
                        thisDay = dayOfMonth;
                        String thisMonthStr = String.valueOf(thisMonth+1);
                        String thisDayStr = String.valueOf(thisDay);
                        if((thisMonth+1)<10){
                            thisMonthStr = "0"+thisMonthStr;
                        }
                        if(thisDay<10){
                            thisDayStr = "0"+thisDayStr;
                        }
                        date = thisYear+"년 "+thisMonthStr+"월 "+thisDayStr+"일";
                        tv_date2.setText(date);
                        vo = helper.selectOnePlan(date);
                        et_content2.setText(vo.getContent());
                    }
                },thisYear,thisMonth,thisDay).show();
            }
        });

        findViewById(R.id.btn_modify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.modifyPlan(date,et_content2.getText().toString().trim());
                Toast.makeText(SelectOne.this, "수정 성공!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        findViewById(R.id.btn_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.deletePlan(date);
                Toast.makeText(SelectOne.this, "삭제 성공!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        findViewById(R.id.btne_maingo3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}