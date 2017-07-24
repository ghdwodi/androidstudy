package com.hb.ex01.a0620_camera5;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

/**
 * Created by HB04-03 on 2017-06-20.
 */

public class CameraActivity extends Activity{
    MyCameraSurface surface;
    int[] ori = {0,90,180,270};
    int n;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);
        surface = (MyCameraSurface)findViewById(R.id.preview);
        n=0;

        findViewById(R.id.btn_shutter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                surface.camera.takePicture(null, null, new Camera.PictureCallback() {
                    @Override
                    public void onPictureTaken(byte[] data, Camera camera) {
                        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
                        Toast.makeText(CameraActivity.this, path, Toast.LENGTH_SHORT).show();
                        String fname = UUID.randomUUID()+".jpg";
                        File file = new File(path+"/"+fname);
                        FileOutputStream fos = null;
                        BufferedOutputStream bos = null;
                        try {
                            fos = new FileOutputStream(file);
                            bos = new BufferedOutputStream(fos);
                            bos.write(data);
                            bos.flush();

                            Intent intent = new Intent();
                            String ff = path+"/"+fname;
                            Uri uri = Uri.parse("file://"+ff);
                            intent.setData(uri);
                            sendBroadcast(intent);
                            Toast.makeText(CameraActivity.this, "저장성공", Toast.LENGTH_SHORT).show();
                            surface.camera.startPreview();
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
                });
            }
        });
        findViewById(R.id.btn_orient).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n++;
                if(n==4){n=0;}
                surface.camera.setDisplayOrientation(ori[n]);
            }
        });
        findViewById(R.id.btn_gal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(CameraActivity.this)
                    .setTitle("메세지")
                    .setMessage("정말 삭제할까요?")
                    .setPositiveButton("종료", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    }).setNegativeButton("취소", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            return;
                        }
                    }).show();
            }
        });
    }
}
