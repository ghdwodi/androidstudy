package com.hb.ex01.a0615_fragment2;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by HB04-03 on 2017-06-15.
 */

public class Ex01 extends Activity{
    Fragment detailFrame;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01);

        FragmentManager fm = getFragmentManager();
        detailFrame = fm.findFragmentById(R.id.detailFrame);
    }
}
