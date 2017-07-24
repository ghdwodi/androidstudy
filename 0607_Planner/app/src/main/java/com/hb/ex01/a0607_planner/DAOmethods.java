package com.hb.ex01.a0607_planner;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by HB04-03 on 2017-06-07.
 */

public class DAOmethods {
    Context context ;
    DAO helper;
    SQLiteDatabase db;
    public DAOmethods() {   }
    public DAOmethods(Context context) {
        this.context = context;
        // DB생성
        helper = new DAO(context);
        // DB 사용하능하게
        db = helper.getWritableDatabase();
    }

    public static DAOmethods db_open(Context context) throws SQLException{
        DAOmethods dao = new DAOmethods(context);
        return dao;
    }
    public void  db_close(){db.close();}

    public ArrayList<VO> selectAll(){
        ArrayList<VO> voList = new ArrayList<>();
        String sql = "select * from planner order by date desc";
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()){
            VO vo = new VO();
            vo.setDate(cursor.getString(1));
            vo.setContent(cursor.getString(2));
            voList.add(vo);
        }
        cursor.close();
        db_close();
        return voList;
    }
    public boolean dateChk(String date){
        String sql = "select * from planner where date=?";
        String[] arr = {date};
        Cursor cursor = db.rawQuery(sql,arr);
        boolean result = cursor.moveToNext();
        return result;
    }

    public VO selectOnePlan(String date){
        String sql = "select * from planner where date=?";
        VO vo = new VO();
        String[] arr = {date};
        Cursor cursor = db.rawQuery(sql,arr);
        if(cursor.moveToFirst()) {
            vo.setDate(cursor.getString(1));
            vo.setContent(cursor.getString(2));
        }else{
            vo.setDate(date);
            vo.setContent("");
        }
        return vo;
    }

    public void insertPlan(String date,String content){
        String sql = "insert into planner values(null,?,?)";
        String[] values = {date,content};
        db.execSQL(sql,values);
        db_close();
    }

    public void modifyPlan(String date,String content){
        String sql = "update planner set content=? where date=?";
        String[] arr = {content,date};
        db.execSQL(sql,arr);
        db_close();
    }

    public void deletePlan(String date){
        String sql = "delete from planner where date=?";
        String[] arr = {date};
        db.execSQL(sql,arr);
        db_close();
    }
}
