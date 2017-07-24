package com.hb.ex01.a0614_camera;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by HB04-03 on 2017-06-14.
 */

public class Ex01 extends Activity{
    ImageView iv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01);
        iv = (ImageView)findViewById(R.id.iv);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); // 가로
//      setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);  // 세로

        findViewById(R.id.btn_cam).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File("/sdcard/DCIM/Camera/img0615.jpg")));
                startActivityForResult(intent,100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = null;
        if(requestCode==100){
            if(resultCode==RESULT_OK){
                File file = new File("/sdcard/DCIM/Camera/img0615.jpg");
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),Uri.fromFile(file));
                    iv.setImageBitmap(bitmap);
                }catch (Exception e){
                }
            }
        }
    }
}
