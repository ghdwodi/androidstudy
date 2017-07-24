package com.hb.ex01.a0530_myapp3;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by HB04-03 on 2017-05-30.
 */

public class Ex03_RadioButtonEvent extends Activity{
    Button btn_cancel, btn_calc;
    RadioGroup rg;
    TextView tv;
    EditText et1,et2;
    String calc;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex02_radiobutton);


        btn_calc = (Button)findViewById(R.id.btn_calc);
        btn_cancel = (Button)findViewById(R.id.btn_cancel);
        rg = (RadioGroup)findViewById(R.id.rg_calc);
        tv = (TextView)findViewById(R.id.tv_result);
        et1 = (EditText)findViewById(R.id.editText_num1);
        et2 = (EditText)findViewById(R.id.editText_num2);
        calc = "";

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setText("");
                et2.setText("");
                rg.clearCheck();
                calc="";
                tv.setText("결과보기");
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.rb_plus:
                        calc="plus";
                        break;
                    case R.id.rb_minus:
                        calc="minus";
                        break;
                    case R.id.rb_multi:
                        calc="multi";
                        break;
                    case R.id.rb_div:
                        calc="div";
                        break;
                }
            }
        });

        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et1.getText().toString().equalsIgnoreCase("")||et2.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(Ex03_RadioButtonEvent.this, "숫자를 입력하세요.", Toast.LENGTH_SHORT).show();
                }else {
                    double su1 = Integer.parseInt(et1.getText().toString());
                    double su2 = Integer.parseInt(et2.getText().toString());
                    switch (calc) {
                        case "":
                            Toast.makeText(Ex03_RadioButtonEvent.this, "연산자를 선택하세요.", Toast.LENGTH_SHORT).show();
                            break;
                        case "plus":
                            tv.setText(String.valueOf(su1 + su2));
                            break;
                        case "minus":
                            tv.setText(String.valueOf(su1 - su2));
                            break;
                        case "multi":
                            tv.setText(String.valueOf(su1 * su2));
                            break;
                        case "div":
                            if (su2 == 0) {
                                Toast.makeText(Ex03_RadioButtonEvent.this, "0으로는 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                            } else {
                                tv.setText(String.valueOf(su1 / su2));
                            }
                            break;
                    }
                    et1.setText("");
                    et2.setText("");
                    rg.clearCheck();
                    calc="";
                }
            }
        });
    }
}