package com.hb.ex01.android_project_leehongjae_20170616;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by HB04-03 on 2017-06-02.
 */

public class BestResult extends Activity{
    ImageView imageView;
    TextView tv_picname;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gal_best);
        imageView = (ImageView)findViewById(R.id.best_imgview);
        tv_picname = (TextView)findViewById(R.id.tv_picname);

        Intent intent = getIntent();
        imageView.setImageResource(intent.getIntExtra("bestImgId",0));
        tv_picname.setText(intent.getStringExtra("bestpicname"));
    }
}
