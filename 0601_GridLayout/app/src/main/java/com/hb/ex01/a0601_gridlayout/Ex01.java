package com.hb.ex01.a0601_gridlayout;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

/**
 * Created by HB04-03 on 2017-06-01.
 */

// GridView도 adapter를 사용한다.
public class Ex01 extends Activity{
    GridView gv1;
    String[] imageName = {"pic1","pic2","pic3","pic4","pic5","pic6"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01);

        gv1 = (GridView)findViewById(R.id.gv);
        gv1.setAdapter(new GridAdapter(this));

        gv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String msg = imageName[position];
                Toast.makeText(Ex01.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
