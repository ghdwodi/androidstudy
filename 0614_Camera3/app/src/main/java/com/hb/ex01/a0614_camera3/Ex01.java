package com.hb.ex01.a0614_camera3;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

/**
 * Created by HB04-03 on 2017-06-14.
 */

public class Ex01 extends Activity{
    FrameLayout preview;
    CameraSurfaceView cameraSurfaceView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01);

        preview = (FrameLayout)findViewById(R.id.preview);
        cameraSurfaceView = new CameraSurfaceView(this);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cameraSurfaceView.capture(new android.hardware.Camera.PictureCallback() {
                    @Override
                    public void onPictureTaken(byte[] data, android.hardware.Camera camera) {
                        Bitmap bitmap = BitmapFactory.decodeByteArray(data,0,data.length);
                        String outStr = MediaStore.Images.Media.insertImage(getContentResolver(),bitmap,"capture","camera");
                        if(outStr==null){
                            return;
                        }else{
                            Uri uri = Uri.parse(outStr);
                            sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,uri));
                        }
                        Toast.makeText(Ex01.this, "저장성공", Toast.LENGTH_SHORT).show();
                        camera.startPreview();
                    }
                });
            }
        });
    }
}