package com.hb.ex01.a0602_intent_addr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

/**
 * Created by HB04-03 on 2017-06-02.
 */

public class Main extends Activity{
    final static int GET_REQUEST01 = 100;
    TextView tv_addr;
    String addr;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);

        tv_addr = (TextView)findViewById(R.id.tv_addr);

        final Intent intent = new Intent(getApplicationContext(),Modify.class);
        addr = tv_addr.getText().toString();


        findViewById(R.id.btn_modify_go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("addr",addr);
                startActivityForResult(intent,GET_REQUEST01);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100){
            if(resultCode==RESULT_OK){
                addr = data.getStringExtra("newAddr");
                tv_addr.setText(addr);
            }else if(resultCode==RESULT_CANCELED){
                tv_addr.setText(addr);
            }
        }
    }
}