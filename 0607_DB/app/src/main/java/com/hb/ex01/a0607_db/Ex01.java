package com.hb.ex01.a0607_db;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.PreparedStatement;

/**
 * Created by HB04-03 on 2017-06-07.
 */

public class Ex01 extends Activity{
    EditText et1,et2,et3,et4;
    Button btn1,btn2,btn3,btn4,btn5;
    DB01 helper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01);

        // 안드로이드 DB는 자체 내장이다. SQLite 라는 것을 이용한다.
        // openCreateDataBase, SQLiteOpenHelper 중 하나를 사용한다.
        // select => rawQuery() 사용한다. 반환형은 Cursor이다.(자바에서는 ResultSet으로 통한다.)
        // 나머지 => execSQL을 사용한다.
        // 그 외엔 JDBC와 사용법이 같다.

        helper = new DB01(this);

        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
        et3 = (EditText)findViewById(R.id.et3);
        et4 = (EditText)findViewById(R.id.et4);

        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = helper.getReadableDatabase();
                String sql = "insert into phone values(null,?,?,?)";
                String[] bindArgs = {et1.getText().toString(),et2.getText().toString(),et3.getText().toString()};
                db.execSQL(sql,bindArgs);
                helper.close();
                et1.setText("");
                et2.setText("");
                et3.setText("");
                et4.setText("Insert OK");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = helper.getReadableDatabase();
                String sql = "delete from phone where name=? and phone=?";
                String[] bindArgs = {et1.getText().toString(),et2.getText().toString()};
                db.execSQL(sql,bindArgs);
                helper.close();
                et1.setText("");
                et2.setText("");
                et4.setText("Delete OK");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = helper.getReadableDatabase();
                String sql = "select * from phone order by num";
                Cursor cursor = db.rawQuery(sql,null);
                StringBuilder sb = new StringBuilder();
                while(cursor.moveToNext()){
                    int num = cursor.getInt(0);
                    String name = cursor.getString(1);
                    String phone = cursor.getString(2);
                    String addr = cursor.getString(3);
                    sb.append(num+","+name+","+phone+","+addr+"\r\n");
                }
                et4.setText(sb);
                cursor.close();
                helper.close();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = helper.getReadableDatabase();
                String sql = "select * from phone where name=? and phone=?";
                String[] bindArgs = {et1.getText().toString(),et2.getText().toString()};
                Cursor cursor = db.rawQuery(sql,bindArgs);
                while(cursor.moveToNext()){
                    et1.setText(cursor.getString(1));
                    et2.setText(cursor.getString(2));
                    et3.setText(cursor.getString(3));
                }
                et4.setText("Search OK");
                cursor.close();
                helper.close();
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = helper.getReadableDatabase();
                String sql = "update phone set addr=? where name=? and phone=?";
                String[] bindArgs = {et3.getText().toString(),et1.getText().toString(),et2.getText().toString()};
                db.execSQL(sql,bindArgs);
                helper.close();
                et1.setText("");
                et2.setText("");
                et3.setText("");
                et4.setText("Update OK");
            }
        });
    }
}
