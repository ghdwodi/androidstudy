package com.hb.ex01.a0614_camera;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

/**
 * Created by HB04-03 on 2017-06-14.
 */

public class Ex02 extends Activity{
    ImageView iv;
    File file;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01);
        iv = (ImageView)findViewById(R.id.iv);

        try {
            file = createFile();
        }catch (Exception e){

        }

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); // 가로
//      setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);  // 세로

        findViewById(R.id.btn_cam).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(intent,200);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = null;
        if(requestCode==200){
            if(resultCode==RESULT_OK){
                try {
//                  bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),Uri.fromFile(file));
//                  iv.setImageBitmap(bitmap);
                    bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                    iv.setImageBitmap(bitmap);
                }catch (Exception e){
                }
            }
        }
    }

    private File createFile() throws Exception{
        Calendar cal = Calendar.getInstance();
        int y = cal.get(Calendar.YEAR);
        int m = cal.get(Calendar.MONTH)+1;
        int d = cal.get(Calendar.DAY_OF_MONTH);
        String k = UUID.randomUUID().toString()+".jpg";
        String imageName = y+"_"+m+"_"+d+"_"+k;
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        return new File(path+"/DCIM/Camera",imageName);
    }
}
