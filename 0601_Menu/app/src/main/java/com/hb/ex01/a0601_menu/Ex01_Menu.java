package com.hb.ex01.a0601_menu;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Toast;

/**
 * Created by HB04-03 on 2017-06-01.
 */

// 메뉴
// 1. 옵션메뉴 : 액티비티의 주메뉴. 메뉴버튼 클릭으로 나옴.
// 2. 컨텍스트메뉴 : 리스트항목, 체크박스, 라디오버튼 사용
// 3. 서브메뉴 : 메뉴 안의 메뉴
public class Ex01_Menu extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01_menu);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    // 메뉴 생성
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem item = menu.add(0,0,0,"짜장면");
        menu.add(0,1,0,"짬뽕");
        menu.add(0,2,0,"볶음밥");
        SubMenu subMenu = menu.addSubMenu(0,3,0,"만두");
        subMenu.addSubMenu(0,4,0,"물만두");
        subMenu.addSubMenu(0,5,0,"군만두");
        subMenu.addSubMenu(0,6,0,"찐만두");
        return super.onCreateOptionsMenu(menu);
    }

    // 메뉴 이벤트 처리

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, item.getTitle()+" 선택", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
