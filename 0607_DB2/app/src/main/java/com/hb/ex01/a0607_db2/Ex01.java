package com.hb.ex01.a0607_db2;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by HB04-03 on 2017-06-07.
 */

public class Ex01 extends Activity{
    DatePicker dp;
    EditText et;
    Button btn;
    String filename;
    DB01 helper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01);

        dp = (DatePicker)findViewById(R.id.dp);
        et = (EditText)findViewById(R.id.et);
        btn = (Button)findViewById(R.id.btn);
        filename = null;
        helper = new DB01(this);
        db = helper.getReadableDatabase();

        // 오늘 날짜
        int mYear = Calendar.getInstance().get(Calendar.YEAR);
        int mMonth = Calendar.getInstance().get(Calendar.MONTH);
        int mDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        filename = mYear+"_"+(mMonth+1)+"_"+mDay;

        // 오늘 날짜정보 받기
        String str = readDiary(filename);

        // 받은 정보 표시하기
        et.setText(str);
        btn.setEnabled(true);

        // 날짜 변경
        dp.init(mYear, mMonth, mDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                filename = year+"_"+monthOfYear+"_"+dayOfMonth;
                String str = readDiary(filename);
                et.setText(str);
                btn.setEnabled(true);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn.getText().toString().equals("수정하기")){
                    String sql = "update mydb set content=? where diaryDate=?";
                    String[] arr = {et.getText().toString().trim(),filename};
                    db.execSQL(sql,arr);
                    Toast.makeText(Ex01.this, "수정 성공", Toast.LENGTH_SHORT).show();
                }else{
                    String sql = "insert into mydb values(?,?)";
                    String[] arr = {filename,et.getText().toString().trim()};
                    db.execSQL(sql,arr);
                    Toast.makeText(Ex01.this, "저장 성공", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public String readDiary(String filename){
        String result=null;
        // 받은 날짜에 DB정보가 있는지 검색
        String sql = "select * from mydb where diaryDate='"+filename+"'";
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor.moveToFirst()){   // 자료가 있는 경우
            result = cursor.getString(1);
            btn.setText("수정하기");
        }else{                      // 자료가 없는 경우
            et.setHint("저장정보 없음");
            btn.setText("새로저장");
        }
        cursor.close();
        return result;
    }
}