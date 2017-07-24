package com.hb.ex01.a0530_myapp3;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


/**
 * Created by HB04-03 on 2017-05-30.
 */

public class Ex02_RadioButtonEvent extends Activity{
    TextView tv1;
    RadioGroup rbg;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01_radiobutton);

        rbg = (RadioGroup)findViewById(R.id.rbGroup);
        tv1 = (TextView)findViewById(R.id.textView2);

        rbg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if(checkedId==R.id.rbRed){
                    tv1.setTextColor(Color.RED);
                }else if(checkedId==R.id.rbGreen){
                    tv1.setTextColor(Color.GREEN);
                }else{
                    tv1.setTextColor(Color.BLUE);
                }
            }
        });
    }
}
