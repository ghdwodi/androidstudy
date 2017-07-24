package com.hb.ex01.a0530_myapp_image;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by HB04-03 on 2017-05-30.
 */


// 넷에 있는 그림 가지고 오기
// Manifest.xml에서 인터넷 사용 허가 받기(퍼미션)
// 네트워크 사용시 반드시 쓰레드처리를 해야 한다.
// 쓰레드처리를 위해 Handler가 필요하다.
public class Ex03_ImageView extends Activity{
    ImageView iv;
    Handler handler = new Handler();
    Bitmap bitmap;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex03_imageview);
        iv = (ImageView)findViewById(R.id.imageView4);

        // 안드로이드의 표준 쓰레드 처리 예시
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://image.zdnet.co.kr/2012/01/26/AxBXdjaxAM1NxAR0ZuOr.jpg");
                    InputStream is = url.openStream();
                    bitmap = BitmapFactory.decodeStream(is);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            iv.setImageBitmap(bitmap);
                        }
                    });
                    is.close();
                }catch (Exception e){

                }
            }
        }).start();
    }
}
