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

public class Ex01_Intent extends Activity{
    final static int GET_REQUEST01 = 100;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01);

        // Intent : 화면 전환
        // 레벨3 : 서브액티비티로부터 결과를 받아서 처리하는 경우
        // 레벨 3의 전체조건 : 반드시 requestCode와 resultCode가 있어야 한다.
        // requestCode : 화면을 이동할 때 보내는 요청코드(상수)
        // resultCode : 서브액티비티로부터 결과를 받는 결과코드(상수)
        // 결과를 받기 위해서는 onActivityResult()를 오버라이딩해야 한다.

        final Intent intent = new Intent(getApplicationContext(), Ex02_Intent.class);

        findViewById(R.id.btn_gosub).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("su1",10);
                intent.putExtra("su2",0);

                startActivityForResult(intent,GET_REQUEST01);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100){
            String msg="";
            if(resultCode==RESULT_OK){
                int result = data.getIntExtra("result",0);
                msg = "계산결과 : "+result;
            }else if(resultCode==RESULT_CANCELED){
                String result = data.getStringExtra("result");
                msg = result;
            }
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }
}
