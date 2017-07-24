package com.hb.ex01.android_project_leehongjae_20170616;

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
    int bestImgId, bestImgIndex;
    ProgressBar pb1,pb2,pb3,pb4,pb5,pb6,pb7,pb8,pb9;
    TextView tv_total;
    String[] picnames = {"독서하는 소녀","꽃장식 모자 소녀","부채를 든 소녀","초상화 소녀","잠자는 소녀","두 자매", "피아노 치는 소녀","피아노 앞의 소녀","해변의 소녀"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gal_result_view);

        tv_total = (TextView)findViewById(R.id.tv_totalvote);

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
        bestImgIndex = intent.getIntExtra("bestImgIndex",0);


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
                intent.putExtra("bestpicname",picnames[bestImgIndex]);
                startActivity(intent);
            }
        });
    }
}
