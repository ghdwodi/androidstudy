package com.hb.ex01.a0601_menu;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * Created by HB04-03 on 2017-06-01.
 */

public class Ex03_Menu extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01_menu);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(Ex03_Menu.this,v);
                popup.getMenuInflater().inflate(R.menu.menu_china,popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(Ex03_Menu.this, item.getTitle()+" 선택", Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popup.show();
            }
        });
    }

    // 메뉴 생성 : xml메뉴를 갖고 온다.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // inflater <- xml코드를 메모리에 적재하고 자바에서 사용가능하게 한다.
 //       getMenuInflater().inflate(R.menu.menu_china,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
