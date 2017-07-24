package com.hb.ex01.android_project_leehongjae_20170616;

import android.app.Activity;
import android.graphics.Color;
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
 * Created by HB04-03 on 2017-06-16.
 */

public class Calc extends Activity{
    Button btn_cancel, btn_calc;
    RadioGroup rg_calc;
    TextView tv;
    EditText et_num1,et_num2;
    String calc;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc_view);

        btn_calc = (Button)findViewById(R.id.btn_calc);
        btn_cancel = (Button)findViewById(R.id.btn_cancel);
        rg_calc = (RadioGroup)findViewById(R.id.rg_calc);
        tv = (TextView)findViewById(R.id.tv_result);
        et_num1 = (EditText)findViewById(R.id.et_num1);
        et_num2 = (EditText)findViewById(R.id.et_num2);
        calc = "";

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_num1.setText("");
                et_num2.setText("");
                rg_calc.clearCheck();
                calc="";
                tv.setText("결과보기");
            }
        });

        rg_calc.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
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
                if(et_num1.getText().toString().equalsIgnoreCase("")||et_num2.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(Calc.this, "숫자를 입력하세요.", Toast.LENGTH_SHORT).show();
                }else {
                    double su1 = Integer.parseInt(et_num1.getText().toString());
                    double su2 = Integer.parseInt(et_num2.getText().toString());
                    switch (calc) {
                        case "":
                            Toast.makeText(Calc.this, "연산자를 선택하세요.", Toast.LENGTH_SHORT).show();
                            break;
                        case "plus":
                            tv.setText("결과 :\t"+String.valueOf(su1 + su2));
                            break;
                        case "minus":
                            tv.setText("결과 :\t"+String.valueOf(su1 - su2));
                            break;
                        case "multi":
                            tv.setText("결과 :\t"+String.valueOf(su1 * su2));
                            break;
                        case "div":
                            if (su2 == 0) {
                                Toast.makeText(Calc.this, "0으로는 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                            } else {
                                double su_divresult = ((int)(su1*100/su2))/100.0;
                                tv.setText("결과 :\t"+String.valueOf(su_divresult));
                            }
                            break;
                    }
                    et_num1.setText("");
                    et_num2.setText("");
                    rg_calc.clearCheck();
                    calc="";
                }
            }
        });
    }
}
