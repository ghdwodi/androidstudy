package com.hb.ex01.a0614_video2;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

/**
 * Created by HB04-03 on 2017-06-14.
 */

public class Ex01 extends Activity{
    VideoView vv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01);

        vv = (VideoView)findViewById(R.id.vv);
        MediaController mc = new MediaController(this);
        vv.setMediaController(mc);

        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        vv.setVideoPath(path+"/Wildlife.wmv");
        vv.requestFocus();

        // 자동으로 동영상 준비할 때 사용되는 리스너
        vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Toast.makeText(Ex01.this, "동영상 준비완료", Toast.LENGTH_SHORT).show();
            }
        });
        vv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(Ex01.this, "동영상 재생완료", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btn_play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vv.seekTo(0);
                vv.start();
            }
        });
        findViewById(R.id.btn_vol).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AudioManager am = (AudioManager)getSystemService(AUDIO_SERVICE);
                int max = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                am.setStreamVolume(AudioManager.STREAM_MUSIC,max,AudioManager.FLAG_SHOW_UI);
            }
        });
    }
}
