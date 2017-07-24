package com.hb.ex01.android_project_leehongjae_20170616;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HB04-03 on 2017-06-07.
 */

public class DAO extends SQLiteOpenHelper{
    SQLiteDatabase db;
    public DAO(Context context) {
        super(context, "schedule_t", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table schedule_t(" +
                "p_idx integer primary key autoincrement," +
                "date text," +
                "content text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table if exists schedule_t";
        db.execSQL(sql);
        onCreate(db);
    }


}
