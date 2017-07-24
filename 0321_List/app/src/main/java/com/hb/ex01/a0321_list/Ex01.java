package com.hb.ex01.a0321_list;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HB04-03 on 2017-05-31.
 */

public class Ex01 extends Activity{
    ListView listView,listView2;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01);

        list = new ArrayList();
        list.add("한국");
        list.add("미국");
        list.add("중국");
        list.add("영국");
        list.add("일본");

        listView = (ListView)findViewById(R.id.lView1);
        listView2 = (ListView)findViewById(R.id.iView2);

        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                list
        );

        listView.setAdapter(adapter);
    }
}
