package com.hb.ex01.a0614_video;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by HB04-03 on 2017-06-14.
 */

public class Ex01 extends Activity{
    VideoView vv1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01);

        vv1 = (VideoView)findViewById(R.id.vv1);

        // 비디오 재생, 중지, 탐색 등의 기능을 사용하기 위해서는
        // MediaController 클래스의 객체를 vv1의 setMediacontroller 매개 변수에 전달.
        MediaController mc = new MediaController(this);

        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
//      vv1.setVideoPath(path+"/Wildlife.wmv");
//      vv1.requestFocus();
//      vv1.start();            // 내부 저장된 파일 재생시

        vv1.setVideoURI(Uri.parse("http://www.sample-videos.com/video/mp4/720/big_buck_bunny_720p_2mb.mp4")); // 인터넷 링크 재생
        vv1.requestFocus();
        vv1.start();

    }
}
