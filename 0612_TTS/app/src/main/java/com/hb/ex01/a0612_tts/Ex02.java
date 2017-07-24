package com.hb.ex01.a0612_tts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by HB04-03 on 2017-06-12.
 */

public class Ex02 extends Activity{
    TextView txtA;
    TextToSpeech tts;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex02);
        txtA = (TextView)findViewById(R.id.txtA);

        // TTS가 가능한지부터 검사
        Intent intent = new Intent();
        intent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(intent,10);


        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==10){
            switch (resultCode){
                case TextToSpeech.Engine.CHECK_VOICE_DATA_PASS:
                    tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
                        @Override
                        public void onInit(int status) {
                            tts.setLanguage(Locale.KOREA);
                            // queueMode
                            // QUEUE_FLUSH : 재생되기 위한 음성과 합성되기 위한 텍스트가 출력되지 못하고 남아있는 경우 남아있는 문자를 비운다.
                            // QUEUE_ADD : 남아있는 경우 그 남아있는 문자를 추가해 출력한다.

                            tts.speak(txtA.getText(),TextToSpeech.QUEUE_FLUSH,null,null);
                        }
                    });
                    break;
                case TextToSpeech.Engine.CHECK_VOICE_DATA_FAIL:
                    Toast.makeText(this, "읽어오기 실패", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
