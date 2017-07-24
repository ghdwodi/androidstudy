package com.hb.ex01.a0612_tts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by HB04-03 on 2017-06-12.
 */

public class Ex04 extends Activity{
    ListView listView;
    TextToSpeech tts;
    ImageView imageView;
    String[] arr = {"boy","dog","androboy","cat"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex04);
        listView = (ListView)findViewById(R.id.listView);
        imageView = (ImageView)findViewById(R.id.imageView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr);
        listView.setAdapter(adapter);

        Intent intent = new Intent();
        intent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(intent,30);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==2){
                    tts.speak(arr[position]+" 는 정답입니다",TextToSpeech.QUEUE_FLUSH,null,null);
                }else{
                    tts.speak(arr[position]+" 는 오답입니다",TextToSpeech.QUEUE_FLUSH,null,null);
                }
            }
        });

        findViewById(R.id.btn7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==30){
            switch (resultCode){
                case TextToSpeech.Engine.CHECK_VOICE_DATA_PASS:
                    tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
                        @Override
                        public void onInit(int status) {
                            tts.setLanguage(Locale.KOREA);
                        }
                    });
                    break;
                case TextToSpeech.Engine.CHECK_VOICE_DATA_FAIL:
                    Toast.makeText(this, "읽어오기 실패", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}