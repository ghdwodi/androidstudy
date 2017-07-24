package com.hb.ex01.a0602_vote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by HB04-03 on 2017-06-02.
 */

public class Result extends Activity{
    Intent intent;
    TextView percent1,percent2,percent3,percent4,percent5,percent6,percent7,percent8,percent9;
    int bestImgId;
    ProgressBar pb1,pb2,pb3,pb4,pb5,pb6,pb7,pb8,pb9;
    TextView tv_total;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultpage);

        tv_total = (TextView)findViewById(R.id.tv_total);

        percent1 = (TextView)findViewById(R.id.percent1);
        percent2 = (TextView)findViewById(R.id.percent2);
        percent3 = (TextView)findViewById(R.id.percent3);
        percent4 = (TextView)findViewById(R.id.percent4);
        percent5 = (TextView)findViewById(R.id.percent5);
        percent6 = (TextView)findViewById(R.id.percent6);
        percent7 = (TextView)findViewById(R.id.percent7);
        percent8 = (TextView)findViewById(R.id.percent8);
        percent9 = (TextView)findViewById(R.id.percent9);

        pb1 = (ProgressBar)findViewById(R.id.pb1);
        pb2 = (ProgressBar)findViewById(R.id.pb2);
        pb3 = (ProgressBar)findViewById(R.id.pb3);
        pb4 = (ProgressBar)findViewById(R.id.pb4);
        pb5 = (ProgressBar)findViewById(R.id.pb5);
        pb6 = (ProgressBar)findViewById(R.id.pb6);
        pb7 = (ProgressBar)findViewById(R.id.pb7);
        pb8 = (ProgressBar)findViewById(R.id.pb8);
        pb9 = (ProgressBar)findViewById(R.id.pb9);

        intent = getIntent();

        percent1.setText(intent.getIntExtra("score_img_"+0,0)+"("+intent.getDoubleExtra("percent_img_"+0,0)+"%)");
        percent2.setText(intent.getIntExtra("score_img_"+1,0)+"("+intent.getDoubleExtra("percent_img_"+1,0)+"%)");
        percent3.setText(intent.getIntExtra("score_img_"+2,0)+"("+intent.getDoubleExtra("percent_img_"+2,0)+"%)");
        percent4.setText(intent.getIntExtra("score_img_"+3,0)+"("+intent.getDoubleExtra("percent_img_"+3,0)+"%)");
        percent5.setText(intent.getIntExtra("score_img_"+4,0)+"("+intent.getDoubleExtra("percent_img_"+4,0)+"%)");
        percent6.setText(intent.getIntExtra("score_img_"+5,0)+"("+intent.getDoubleExtra("percent_img_"+5,0)+"%)");
        percent7.setText(intent.getIntExtra("score_img_"+6,0)+"("+intent.getDoubleExtra("percent_img_"+6,0)+"%)");
        percent8.setText(intent.getIntExtra("score_img_"+7,0)+"("+intent.getDoubleExtra("percent_img_"+7,0)+"%)");
        percent9.setText(intent.getIntExtra("score_img_"+8,0)+"("+intent.getDoubleExtra("percent_img_"+8,0)+"%)");

        pb1.setProgress((int)intent.getDoubleExtra("percent_img_"+0,0));
        pb2.setProgress((int)intent.getDoubleExtra("percent_img_"+1,0));
        pb3.setProgress((int)intent.getDoubleExtra("percent_img_"+2,0));
        pb4.setProgress((int)intent.getDoubleExtra("percent_img_"+3,0));
        pb5.setProgress((int)intent.getDoubleExtra("percent_img_"+4,0));
        pb6.setProgress((int)intent.getDoubleExtra("percent_img_"+5,0));
        pb7.setProgress((int)intent.getDoubleExtra("percent_img_"+6,0));
        pb8.setProgress((int)intent.getDoubleExtra("percent_img_"+7,0));
        pb9.setProgress((int)intent.getDoubleExtra("percent_img_"+8,0));

        tv_total.setText("총 투표수 : "+String.valueOf(intent.getIntExtra("totalScore",0)));

        bestImgId = intent.getIntExtra("bestImgId",0);

        findViewById(R.id.btn_return).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED,intent);
                finish();
            }
        });

        findViewById(R.id.btn_best).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),BestResult.class);
                intent.putExtra("bestImgId",bestImgId);
                startActivity(intent);
            }
        });
    }
}
