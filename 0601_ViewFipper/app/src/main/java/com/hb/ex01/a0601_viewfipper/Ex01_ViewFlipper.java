package com.hb.ex01.a0601_viewfipper;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

/**
 * Created by HB04-03 on 2017-06-01.
 */

public class Ex01_ViewFlipper extends Activity{
    Button btn1,btn2;
    ViewFlipper vf;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01_viewflipper);

        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        vf = (ViewFlipper)findViewById(R.id.vf);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vf.showPrevious();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vf.showNext();
            }
        });

        vf.setFlipInterval(1000);
        vf.startFlipping();
    }
}
