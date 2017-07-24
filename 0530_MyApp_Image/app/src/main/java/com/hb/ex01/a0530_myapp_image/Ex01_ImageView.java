package com.hb.ex01.a0530_myapp_image;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

/**
 * Created by HB04-03 on 2017-05-30.
 */

public class Ex01_ImageView extends Activity{
    ImageView iv1,iv2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01_imageview);

        iv1 = (ImageView)findViewById(R.id.imageView);
        iv2 = (ImageView)findViewById(R.id.imageView2);

        // src를 직접 입력
        iv1.setImageResource(R.mipmap.ic_launcher);

        // 비트맵으로 입력
        iv2.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.dog));
    }
}
