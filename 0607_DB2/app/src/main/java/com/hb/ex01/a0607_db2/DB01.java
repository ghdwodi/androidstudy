package com.hb.ex01.a0607_db2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HB04-03 on 2017-06-07.
 */

public class DB01 extends SQLiteOpenHelper{
    public DB01(Context context) {
        super(context, "mydb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table mydb(" +
                "diaryDate text primary key," +
                "content text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table if exists mydb";
        db.execSQL(sql);
        onCreate(db);
    }
}
