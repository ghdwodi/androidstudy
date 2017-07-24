package com.hb.ex01.a0615_fragment2;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

/**
 * Created by HB04-03 on 2017-06-15.
 */

public class Ex03 extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.ex03,container,false);
    }

    // 싱글톤 패턴
    public static Ex03 newInstance(String str){
        Ex03 detail = new Ex03();
        // Intent처럼 정보를 저장한 후 나중에 불러다 사용
        Bundle bundle = new Bundle();
        bundle.putString("title",str);
        detail.setArguments(bundle);
        return detail;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView tv_url = (TextView)getActivity().findViewById(R.id.tv_url);
        WebView webview1 = (WebView)getActivity().findViewById(R.id.webview1);
        tv_url.setText(getArguments().getString("title"));
        webview1.loadUrl(getArguments().getString("title"));
    }
}