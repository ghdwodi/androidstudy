package com.hb.ex01.a0620_camera4;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

/**
 * Created by HB04-03 on 2017-06-20.
 */

public class CameraActivity extends Activity{
    Button btn;
    CameraPreview preview;
    FrameLayout layout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);
        layout = (FrameLayout)findViewById(R.id.layout);
        btn = (Button)findViewById(R.id.btn);
        preview = new CameraPreview(this);
        layout.addView(preview);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setEnabled(false);

                // 포커스가 맞춰졌을 때 수행하는 작업
                preview.camera.autoFocus(new Camera.AutoFocusCallback() {
                    @Override
                    public void onAutoFocus(boolean success, Camera camera) {
                        btn.setEnabled(true);
                    }
                });

                // 사진 찍기

                preview.camera.takePicture(null,null,picture);
            }
        });
    }

    Camera.PictureCallback picture = new Camera.PictureCallback() {
        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            // 저장경로
            String path = Environment.getExternalStorageDirectory().getAbsolutePath();
            String fname = UUID.randomUUID()+".jpg";
            File file = new File(path+"/"+fname);
            FileOutputStream fos = null;
            BufferedOutputStream bos = null;
            try {
                fos = new FileOutputStream(file);
                bos = new BufferedOutputStream(fos);
                bos.write(data);
                bos.flush();

                // 저장된 파일 스캐닝
                Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                String ff = path+"/"+fname;
                Uri uri = Uri.parse("file://"+ff);
                intent.setData(uri);
                sendBroadcast(intent);
                Toast.makeText(CameraActivity.this, "저장 성공", Toast.LENGTH_SHORT).show();
            }catch (Exception e){
            }finally {
                try {
                    if(bos!=null){
                        bos.close();
                    }
                    if(fos!=null){
                        fos.close();
                    }
                }catch (Exception e2){
                }
            }
        }
    };
}
