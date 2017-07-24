package com.hb.ex01.a0531_myapp03_progressbar2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

/**
 * Created by HB04-03 on 2017-05-31.
 */

public class Ex01_RatingBar extends Activity{
    RatingBar r1,r2,r3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01_ratingbar);

        r1 = (RatingBar)findViewById(R.id.ratingBar1);
        r2 = (RatingBar)findViewById(R.id.ratingBar2);
        r3 = (RatingBar)findViewById(R.id.ratingBar3);

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r1.setRating(r1.getRating()+r1.getStepSize());
                r2.setRating(r2.getRating()+r2.getStepSize());
                r3.setRating(r3.getRating()+r3.getStepSize());
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r1.setRating(r1.getRating()-r1.getStepSize());
                r2.setRating(r2.getRating()-r2.getStepSize());
                r3.setRating(r3.getRating()-r3.getStepSize());
            }
        });
    }
}
