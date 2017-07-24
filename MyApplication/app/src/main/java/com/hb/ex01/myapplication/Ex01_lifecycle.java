package com.hb.ex01.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by HB04-03 on 2017-05-29.
 */

// 안드로이드의 4대 컴포넌트
// activity, provider, receiver, service
// 화면을 구성 <= 4대 컴포넌트 중 activity이다. 무조건 java에서 상속.

public class Ex01_lifecycle extends Activity {
    // 화면을 구성하는 Activity의 생명 주기를 알아보자.
    // 이하 오버라이딩 메소드들은 전부 부팅 순서를 이룬다. 하나라도 빠져선 안 된다.

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 해당 화면을 구성하는 xml을 연결한다.
        setContentView(R.layout.first);
        Toast.makeText(this,"onCreate 메소드",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart 메소드",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume 메소드",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"onPause 메소드",Toast.LENGTH_LONG).show();
    }

    // onStop()과 onRestart()는 순서가 바뀔 때도 있다.
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop 메소드",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestart 메소드",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"onDestroy 메소드",Toast.LENGTH_LONG).show();
    }
}