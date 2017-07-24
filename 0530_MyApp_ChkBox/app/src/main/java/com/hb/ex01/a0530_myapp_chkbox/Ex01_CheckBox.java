package com.hb.ex01.a0530_myapp_chkbox;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

/**
 * Created by HB04-03 on 2017-05-30.
 */

public class Ex01_CheckBox extends Activity{
    CheckBox chkbox1, chkbox2;
    TextView tv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01_checkbox);

        chkbox1 = (CheckBox)findViewById(R.id.checkBox1);
        chkbox2 = (CheckBox)findViewById(R.id.checkBox2);
        tv = (TextView)findViewById(R.id.textView);
        
        chkbox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tv.setTextColor(Color.RED);
                }else{
                    tv.setTextColor(Color.BLACK);
                }
            }
        });

        chkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tv.setTextSize(50);
                }else{
                    tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,30);
                }
            }
        });
    }
}
