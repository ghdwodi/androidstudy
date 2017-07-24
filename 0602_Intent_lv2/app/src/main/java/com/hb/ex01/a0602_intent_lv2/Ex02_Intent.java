package com.hb.ex01.a0602_intent_lv2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

/**
 * Created by HB04-03 on 2017-06-02.
 */

public class Ex02_Intent extends Activity{
    String msg;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex02);

        // Intent로 넘어온 데이터를 받아서 저장하기

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        int su = intent.getIntExtra("su",0);

        msg = "이름 : "+name+"\n나이 : "+su;

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();


        findViewById(R.id.btn_end).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
