package com.hb.ex01.a0530_myapp_image;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by HB04-03 on 2017-05-30.
 */

public class Ex02_ImageView extends Activity{
    ImageView iv;
    int i;
    int[] images =  {R.drawable.boy,R.drawable.coffe,R.drawable.dog,R.drawable.donald};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex02_imageview);

        iv = (ImageView)findViewById(R.id.imageView3);
        iv.setImageResource(R.drawable.boy);
        i=0;


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.setImageResource(images[++i%4]);
            }
        });
    }
}
