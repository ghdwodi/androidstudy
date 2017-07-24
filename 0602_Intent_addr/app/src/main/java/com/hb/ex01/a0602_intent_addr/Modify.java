package com.hb.ex01.a0602_intent_addr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

/**
 * Created by HB04-03 on 2017-06-02.
 */

public class Modify extends Activity{
    EditText et_addr;
    String newAddr;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modifypage);

        et_addr = (EditText)findViewById(R.id.et_addr);

        final Intent intent1 = getIntent();
        final Intent intent2 = new Intent();
        newAddr = intent1.getStringExtra("addr");
        et_addr.setText(newAddr);

        findViewById(R.id.btn_modify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newAddr = et_addr.getText().toString();
                intent2.putExtra("newAddr",newAddr);
                setResult(RESULT_OK,intent2);
                finish();
            }
        });

        findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent2.putExtra("newAddr",newAddr);
                setResult(RESULT_CANCELED,intent2);
                finish();
            }
        });
    }
}
