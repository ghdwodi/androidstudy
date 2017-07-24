package com.hb.ex01.a0613_audio2;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import java.io.File;

/**
 * Created by HB04-03 on 2017-06-13.
 */

// uses permission에서 record audio를 허용해야 한다.
public class Ex01 extends Activity{
    String path;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01);
        path = null;

        // 녹음기 호출 및 녹음
        findViewById(R.id.btn_record).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
                startActivityForResult(intent,10);
            }
        });
        
        // 재생
        findViewById(R.id.btn_play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(path!=null) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.fromFile(new File(path)), "audio/3gpp");
                    startActivity(intent);
                }else{
                    Toast.makeText(Ex01.this, "녹음된 파일이 없습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==10){
            if(resultCode==RESULT_OK){
                Uri record = data.getData();
                Cursor cursor = getContentResolver().query(record,null,null,null,null);
                cursor.moveToNext();
                path = cursor.getString(cursor.getColumnIndex(MediaStore.MediaColumns.DATA));
            }
        }
    }
}
