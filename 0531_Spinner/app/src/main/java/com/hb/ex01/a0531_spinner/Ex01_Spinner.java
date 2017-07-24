package com.hb.ex01.a0531_spinner;

import android.app.Activity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

/**
 * Created by HB04-03 on 2017-05-31.
 */

// 스피너나 리스트뷰를 어댑터 뷰(고급 뷰)라고 한다.
// 어댑터 뷰는 어댑터를 반드시 사용해야 한다. 어댑터는 보통 배열이나 Arraylist를 사용한다.
public class Ex01_Spinner extends Activity{
    Spinner sp1,sp2;
    String[] str = {"망고","구아바","스타후르츠","두리안","람부탄"};
    ImageView iv;
    int[] images = {R.drawable.mango,R.drawable.guava,R.drawable.starfruit,R.drawable.durian,R.drawable.rambutan};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01_spinner);

        //////////// 레이아웃 ////////////

        sp1 = (Spinner)findViewById(R.id.spinner1);
        sp2 = (Spinner)findViewById(R.id.spinner2);
        iv = (ImageView)findViewById(R.id.imageView);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,   // Context
                android.R.layout.simple_spinner_dropdown_item,  // 보여질 모양
                str     // 들어갈 데이터
        );

        sp1.setAdapter(arrayAdapter);

        // sp2는 xml로 만들어 보자.
        sp2.setSelection(3);

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                iv.setImageResource(images[position]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Ex01_Spinner.this, sp2.getAdapter().getItem(position).toString(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }
}
