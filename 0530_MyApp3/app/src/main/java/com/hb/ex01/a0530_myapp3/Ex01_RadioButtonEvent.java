package com.hb.ex01.a0530_myapp3;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;


/**
 * Created by HB04-03 on 2017-05-30.
 */

public class Ex01_RadioButtonEvent extends Activity{
    TextView tv1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01_radiobutton);

        RadioButton rbRed = (RadioButton)findViewById(R.id.rbRed);
        RadioButton rbGreen = (RadioButton)findViewById(R.id.rbGreen);
        RadioButton rbBlue = (RadioButton)findViewById(R.id.rbBlue);
        tv1 = (TextView)findViewById(R.id.textView2);

        rbRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setTextColor(Color.RED);
            }
        });

        rbGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setTextColor(Color.GREEN);
            }
        });

        rbBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setTextColor(Color.BLUE);
            }
        });
    }
}
