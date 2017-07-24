package com.hb.ex01.a0603_intent_lv3;

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
    int result=0;
    String msg;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex02);

        // 레벨 3 : Intent로 넘어온 데이터를 받아서 처리하기


        findViewById(R.id.btn_end).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = getIntent();
                Intent intent1 = new Intent();
                int su1 = intent.getIntExtra("su1",0);
                int su2 = intent.getIntExtra("su2",0);
                if(su2!=0){
                    result = su1 / su2;
                    intent1.putExtra("result",result);
                    setResult(RESULT_OK,intent1);
                }else{
                    intent1.putExtra("result","0으로는 나눌 수 없음.");
                    setResult(RESULT_CANCELED,intent1);
                }
                finish();
            }
        });
    }
}
