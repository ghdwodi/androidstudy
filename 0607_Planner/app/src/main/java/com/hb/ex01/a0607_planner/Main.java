package com.hb.ex01.a0607_planner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by HB04-03 on 2017-06-07.
 */

public class Main extends Activity{
//    final static int GET_REQUEST_SELECTONE = 100;
//    final static int GET_REQUEST_SELECTALL = 101;
//    final static int GET_REQUEST_INSERT = 200;
//    final static int GET_REQUEST_UPDATE = 300;
//    final static int GET_REQUEST_DELETE = 400;
    Intent intent_insert,intent_selectAll,intent_selectOne;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        intent_insert = new Intent(getApplicationContext(),Insert.class);
        intent_selectOne = new Intent(getApplicationContext(),SelectOne.class);
        intent_selectAll = new Intent(getApplicationContext(),SelectAll.class);

        findViewById(R.id.btn_insertgo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent_insert);
            }
        });

        findViewById(R.id.btn_selectonego).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent_selectOne);
            }
        });

        findViewById(R.id.btn_selectallgo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent_selectAll);
            }
        });

        findViewById(R.id.btn_exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
