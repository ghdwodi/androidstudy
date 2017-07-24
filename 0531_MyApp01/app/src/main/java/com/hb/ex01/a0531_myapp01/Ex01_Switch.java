package com.hb.ex01.a0531_myapp01;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * Created by HB04-03 on 2017-05-31.
 */

public class Ex01_Switch extends Activity{
    Switch sw;
    ToggleButton tb;
    TextView tv1, tv2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01_switch);

        sw = (Switch)findViewById(R.id.sw);
        tb = (ToggleButton)findViewById(R.id.tb);
        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tv1.setText("스위치 켜졌다.");
                }else{
                    tv1.setText("스위치 꺼졌다.");
                }
            }
        });

        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tv2.setTextColor(Color.RED);
                }else{
                    tv2.setTextColor(Color.BLACK);
                }
            }
        });
    }
}
