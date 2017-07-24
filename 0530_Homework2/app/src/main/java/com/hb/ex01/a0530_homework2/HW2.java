package com.hb.ex01.a0530_homework2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by HB04-03 on 2017-05-30.
 */

public class HW2 extends Activity{
    ImageView iv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hw2);

        iv = (ImageView)findViewById(R.id.imageView);
        iv.setImageResource(R.drawable.boy);

        findViewById(R.id.bt_boy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.setImageResource(R.drawable.boy);
            }
        });

        findViewById(R.id.bt_coffe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.setImageResource(R.drawable.coffe);
            }
        });

        findViewById(R.id.bt_dog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.setImageResource(R.drawable.dog);
            }
        });

        findViewById(R.id.bt_Donald).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.setImageResource(R.drawable.donald);
            }
        });
    }
}
