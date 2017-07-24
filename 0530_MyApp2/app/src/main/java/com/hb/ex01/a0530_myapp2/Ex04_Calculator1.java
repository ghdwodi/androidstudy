package com.hb.ex01.a0530_myapp2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by HB04-03 on 2017-05-30.
 */

public class Ex04_Calculator1 extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator1);


        findViewById(R.id.btn_result).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView result = (TextView)findViewById(R.id.textView_result);
                int su1 = Integer.parseInt(((EditText)findViewById(R.id.editText_su1)).getText().toString());
                int su2 = Integer.parseInt(((EditText)findViewById(R.id.editText_su2)).getText().toString());
                String calc = ((EditText)findViewById(R.id.editText_calc)).getText().toString();
                if(calc.equalsIgnoreCase("+")){
                    int res = su1+su2;
                    result.setText(res+"");
                }else if(calc.equalsIgnoreCase("-")){
                    int res = su1-su2;
                    result.setText(res+"");
                }else if(calc.equalsIgnoreCase("*")){
                    int res = su1*su2;
                    result.setText(res+"");
                }else if(calc.equalsIgnoreCase("/")){
                    if(su2==0){
                        Toast.makeText(Ex04_Calculator1.this, "0으로는 나눌 수 없습니다.", Toast.LENGTH_LONG).show();
                    }else{
                        int res = su1/su2;
                        result.setText(res+"");
                    }
                }else{
                    Toast.makeText(Ex04_Calculator1.this, "연산자를 제대로 입력하십시오.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
