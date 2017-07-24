package com.hb.ex01.a0531_list2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by HB04-03 on 2017-05-31.
 */

public class Ex01 extends Activity{
    ListView listView;
    ArrayList<ListViewVO> list;
    ListViewAdapter listViewAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01);
        listView = (ListView)findViewById(R.id.list1);
        list = new ArrayList<>();
        list.add(new ListViewVO(R.drawable.pic1,"아기사진1"));
        list.add(new ListViewVO(R.drawable.pic2,"아기사진2"));
        list.add(new ListViewVO(R.drawable.pic3,"아기사진3"));
        list.add(new ListViewVO(R.drawable.pic4,"아기사진4"));
        list.add(new ListViewVO(R.drawable.pic5,"아기사진5"));
        list.add(new ListViewVO(R.drawable.pic6,"아기사진6"));

        listViewAdapter = new ListViewAdapter(this,R.layout.ex01_1,list);

        listView.setAdapter(listViewAdapter);
    }
}
