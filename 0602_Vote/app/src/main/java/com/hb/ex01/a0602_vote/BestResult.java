package com.hb.ex01.a0602_vote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by HB04-03 on 2017-06-02.
 */

public class BestResult extends Activity{
    ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bestresult);
        imageView = (ImageView)findViewById(R.id.best_imgview);

        Intent intent = getIntent();
        imageView.setImageResource(intent.getIntExtra("bestImgId",0));
    }
}
