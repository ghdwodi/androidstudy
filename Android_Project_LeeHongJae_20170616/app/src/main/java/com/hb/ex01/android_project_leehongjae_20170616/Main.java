package com.hb.ex01.android_project_leehongjae_20170616;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by HB04-03 on 2017-06-16.
 */

public class Main extends Activity{
    Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_view);

        findViewById(R.id.btn_calc_go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Main.this,Calc.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_gallary_go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Main.this,Gallary.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_music_go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Main.this,Music.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_schedule_go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Main.this,Scheduler_main.class);
                startActivity(intent);
            }
        });
    }
}
