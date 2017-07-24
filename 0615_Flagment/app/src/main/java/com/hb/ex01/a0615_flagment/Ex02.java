package com.hb.ex01.a0615_flagment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by HB04-03 on 2017-06-15.
 */

public class Ex02 extends Fragment{
    // xml 파일을 inflate한다. (메모리에 적재한 후 자바에서 인식할 수 있도록 만든다)

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.ex02,container,false);
    }
}