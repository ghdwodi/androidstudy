package com.hb.ex01.a0615_fragment2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by HB04-03 on 2017-06-15.
 */

public class Ex02 extends Fragment{
    Button btn_google,btn_naver,btn_daum;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ex02,container,false);
        btn_google = (Button)view.findViewById(R.id.btn_google);
        btn_naver = (Button)view.findViewById(R.id.btn_naver);
        btn_daum = (Button)view.findViewById(R.id.btn_daum);

        btn_google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showData("http://www.google.com");
            }
        });
        btn_naver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showData("http://www.naver.com");
            }
        });
        btn_daum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showData("http://www.daum.net");
            }
        });

        return view;
    }
    public void showData(String url){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment fragment = Ex03.newInstance(url);
        ft.replace(R.id.detailFrame,fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }
}
