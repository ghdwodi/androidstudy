package com.hb.ex01.a0602_intent_lv2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by HB04-03 on 2017-06-02.
 */

public class Ex01_Intent extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01);

        // Intent : 화면 전환
        // 레벨2 : 데이터를 가지고 화면 이동
        // Ex01_Intent => Ex02_Intent로 이동
        // Intent 생성자 : Intent(현재위치, 이동위치)
        // 데이터를 담기(String) : 맵형식("이름","값") <= 'putExtra'

        final Intent intent = new Intent(getApplicationContext(), Ex02_Intent.class);

        findViewById(R.id.btn_gosub).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("name","두치와뿌꾸");
                intent.putExtra("su",12);
                startActivity(intent);
            }
        });
    }
}
