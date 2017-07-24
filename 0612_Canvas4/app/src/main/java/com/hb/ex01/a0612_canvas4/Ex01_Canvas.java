package com.hb.ex01.a0612_canvas4;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by HB04-03 on 2017-06-12.
 */

public class Ex01_Canvas extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Ex01_View(this));
    }
}
