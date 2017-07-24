package com.hb.ex01.a0607_db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HB04-03 on 2017-06-07.
 */

// DB처리를 위한 클래스. SQLiteOpenHelper를 상속받는다.
public class DB01 extends SQLiteOpenHelper{
    // context : 컨텍스트
    // name : DB이름
    // factory : 커서를 저장하는 매개변수(표준 : null)
    // version : 버전
    public DB01(Context context) {
        super(context, "phone", null, 1);
    }

    // 객체 생성시 DB이름이 없으면 onCreate로 자동 실행
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table phone(" +
                "num integer primary key autoincrement," +
                "name text,phone text,addr text)";
        db.execSQL(sql);
        sql = "insert into phone values(null,'hong','010-7979-7777','서울시 광진구')";
        db.execSQL(sql);
    }

    // 객체 생성시 DB이름이 있는데 버전이 맞지 않는 경우
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 기존 DB 삭제하고 onCreate()를 다시 호출
        String sql = "drop table if exists phone";
        db.execSQL(sql);
        onCreate(db);
    }
}
