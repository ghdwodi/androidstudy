package com.hb.ex01.a0613_audio;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by HB04-03 on 2017-06-13.
 */

// MediaPlayer 활용하기 => 반드시 사용자 퍼미션을 해야 한다.

public class Ex02 extends Activity{
    MediaPlayer mp;
    static final String ID = "/sdcard/back.mp3";
    int playBackPosition = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex02);
        if(mp!=null){
            mp.release();
        }
        mp = new MediaPlayer();

        findViewById(R.id.btn_play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mp.setDataSource(ID);
                    mp.prepare();
                    mp.start();
                }catch (Exception e){
                }
            }
        });
        findViewById(R.id.btn_pause).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playBackPosition = mp.getCurrentPosition();
                mp.pause();
            }
        });
        findViewById(R.id.btn_replay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                mp.seekTo(playBackPosition);
            }
        });
        findViewById(R.id.btn_end).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp!=null){
                    mp.release();
                }
                mp = new MediaPlayer();
            }
        });
    }

    // 앱이 끝날 때 자원 해제
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mp!=null){
            mp.release();
        }
    }
}
