package com.hb.ex01.a0615_flagment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by HB04-03 on 2017-06-15.
 */

public class Ex01 extends Activity{
    Fragment fragment1;
    TextView tv1,tv2;
    Button btn1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01);

        // 사용가능
        tv1 = (TextView)findViewById(R.id.tv1);
//      tv2 = (TextView)findViewById(R.id.tv2);
//      btn1 = (Button)findViewById(R.id.btn1);
//
//      btn1.setOnClickListener(new View.OnClickListener() {
//          @Override
//          public void onClick(View v) {
//              tv1.setText("메인");
//              tv2.setText("프래그먼트 텍스트");
//         }
//      });

        // 플래그먼트매니저 얻기
        FragmentManager fm = getFragmentManager();
        fragment1 = fm.findFragmentById(R.id.fragment1);
        btn1 = (Button)fragment1.getView().findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv2 = (TextView)fragment1.getView().findViewById(R.id.tv2);
                tv1.setText("메인");
                tv2.setText("프래그먼트 텍스트");
            }
        });
    }
}
