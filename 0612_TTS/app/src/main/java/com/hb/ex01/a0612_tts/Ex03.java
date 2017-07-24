package com.hb.ex01.a0612_tts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by HB04-03 on 2017-06-12.
 */

public class Ex03 extends Activity{
    EditText editText;
    TextToSpeech tts;
    Button btn5,btn6;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex03);
        editText = (EditText)findViewById(R.id.editText);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);

        Intent intent = new Intent();
        intent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(intent,20);

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence msg = editText.getText();
                if(msg.length()==0){
                    Toast.makeText(Ex03.this, "문장을 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                tts.speak(msg,TextToSpeech.QUEUE_FLUSH,null,null);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==20){
            switch (resultCode){
                case TextToSpeech.Engine.CHECK_VOICE_DATA_PASS:
                    btn5.setEnabled(true);
                    tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
                        @Override
                        public void onInit(int status) {
                            tts.setLanguage(Locale.KOREA);
                        }
                    });
                    break;
                case TextToSpeech.Engine.CHECK_VOICE_DATA_FAIL:
                    Toast.makeText(this, "읽어오기 실패", Toast.LENGTH_SHORT).show();
                    btn5.setEnabled(false);
                    break;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
