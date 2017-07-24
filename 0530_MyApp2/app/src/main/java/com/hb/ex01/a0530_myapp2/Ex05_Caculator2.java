package com.hb.ex01.a0530_myapp2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.test.suitebuilder.TestMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by HB04-03 on 2017-05-30.
 */

public class Ex05_Caculator2 extends Activity{
    int su1, su2, res;
    String calc;
    String result;
    TextView tv_res;
    EditText et_su1,et_su2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator2);

        et_su1 = (EditText)findViewById(R.id.et_su1);
        et_su2 = (EditText)findViewById(R.id.et_su2);
        tv_res = (TextView)findViewById(R.id.tv_res);


        findViewById(R.id.button_plus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_su1.getText().length()==0 || et_su2.getText().length()==0){
                    Toast.makeText(Ex05_Caculator2.this, "숫자를 입력하세요.", Toast.LENGTH_SHORT).show();
                }else{
                    su1 = Integer.parseInt(et_su1.getText().toString());
                    su2 = Integer.parseInt(et_su2.getText().toString());
                    tv_res.setText((su1+su2)+"");
                    et_su1.setText("");
                    et_su2.setText("");
                }
            }
        });

        findViewById(R.id.button_minus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_su1.getText().length()==0 || et_su2.getText().length()==0){
                    Toast.makeText(Ex05_Caculator2.this, "숫자를 입력하세요.", Toast.LENGTH_SHORT).show();
                }else{
                    su1 = Integer.parseInt(et_su1.getText().toString());
                    su2 = Integer.parseInt(et_su2.getText().toString());
                    tv_res.setText((su1-su2)+"");
                    et_su1.setText("");
                    et_su2.setText("");
                }
            }
        });

        findViewById(R.id.button_multi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_su1.getText().length()==0 || et_su2.getText().length()==0){
                    Toast.makeText(Ex05_Caculator2.this, "숫자를 입력하세요.", Toast.LENGTH_SHORT).show();
                }else{
                    su1 = Integer.parseInt(et_su1.getText().toString());
                    su2 = Integer.parseInt(et_su2.getText().toString());
                    tv_res.setText((su1*su2)+"");
                    et_su1.setText("");
                    et_su2.setText("");
                }
            }
        });

        findViewById(R.id.button_div).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_su1.getText().length()==0 || et_su2.getText().length()==0){
                    Toast.makeText(Ex05_Caculator2.this, "숫자를 입력하세요.", Toast.LENGTH_SHORT).show();
                }else if(et_su2.getText().toString().equalsIgnoreCase("0")){
                    Toast.makeText(Ex05_Caculator2.this, "0으로는 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                }else{
                    su1 = Integer.parseInt(et_su1.getText().toString());
                    su2 = Integer.parseInt(et_su2.getText().toString());
                    tv_res.setText((su1/su2)+"");
                    et_su1.setText("");
                    et_su2.setText("");
                }
            }
        });
    }
}
