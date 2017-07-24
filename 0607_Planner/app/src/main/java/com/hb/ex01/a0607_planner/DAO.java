package com.hb.ex01.a0607_planner;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by HB04-03 on 2017-06-07.
 */

public class DAO extends SQLiteOpenHelper{
    SQLiteDatabase db;
    public DAO(Context context) {
        super(context, "planner", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table planner(" +
                "p_idx integer primary key autoincrement," +
                "date text," +
                "content text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table if exists planner";
        db.execSQL(sql);
        onCreate(db);
    }


}
