package com.hb.ex01.a0613_audio;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by HB04-03 on 2017-06-13.
 */

// 음원은 미리 Tools -> android device moniter를 이용해 sdcard에 넣어 두었다.
public class Ex01 extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01);

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("file:///sdcard/back.mp3");
                intent.setDataAndType(uri,"audio/mp3");
                startActivity(intent);
            }
        });
    }
}