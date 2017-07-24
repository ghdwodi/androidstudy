package com.hb.ex01.a0602_vote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by HB04-03 on 2017-06-02.
 */

public class ImageVote extends Activity{
    final static int GET_REQUEST01 = 100;
    ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9;
    int[] images = {R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5,R.drawable.pic6,R.drawable.pic7,R.drawable.pic8,R.drawable.pic9};
    Score score;
    Intent intent;
    TextView tv_count;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.images);

        intent = new Intent(getApplicationContext(),Result.class);
        score = new Score();
        tv_count = (TextView)findViewById(R.id.tv_count);
        tv_count.setText("투표수 : "+String.valueOf(score.getTotalScore())+"회");

        img1 = (ImageView)findViewById(R.id.img1);
        img2 = (ImageView)findViewById(R.id.img2);
        img3 = (ImageView)findViewById(R.id.img3);
        img4 = (ImageView)findViewById(R.id.img4);
        img5 = (ImageView)findViewById(R.id.img5);
        img6 = (ImageView)findViewById(R.id.img6);
        img7 = (ImageView)findViewById(R.id.img7);
        img8 = (ImageView)findViewById(R.id.img8);
        img9 = (ImageView)findViewById(R.id.img9);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score.addScore(0);
                tv_count.setText("투표수 : "+String.valueOf(score.getTotalScore())+"회");
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score.addScore(1);
                tv_count.setText("투표수 : "+String.valueOf(score.getTotalScore())+"회");
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score.addScore(2);
                tv_count.setText("투표수 : "+String.valueOf(score.getTotalScore())+"회");
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score.addScore(3);
                tv_count.setText("투표수 : "+String.valueOf(score.getTotalScore())+"회");
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score.addScore(4);
                tv_count.setText("투표수 : "+String.valueOf(score.getTotalScore())+"회");
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score.addScore(5);
                tv_count.setText("투표수 : "+String.valueOf(score.getTotalScore())+"회");
            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score.addScore(6);
                tv_count.setText("투표수 : "+String.valueOf(score.getTotalScore())+"회");
            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score.addScore(7);
                tv_count.setText("투표수 : "+String.valueOf(score.getTotalScore())+"회");
            }
        });
        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score.addScore(8);
                tv_count.setText("투표수 : "+String.valueOf(score.getTotalScore())+"회");
            }
        });

        findViewById(R.id.btn_result_go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] scores = score.getScores();
                int bestImgId = score.getLargestIndex();
                double[] percents = score.getPercentArray();
                intent.putExtra("totalScore",score.getTotalScore());
                for(int i=0;i<scores.length;i++){
                    intent.putExtra("score_img_"+i,scores[i]);
                    intent.putExtra("percent_img_"+i,percents[i]);
                }
                intent.putExtra("bestImgId",images[bestImgId]);
                score.clearScores();
                startActivityForResult(intent,GET_REQUEST01);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==GET_REQUEST01){
            if(resultCode==RESULT_CANCELED){
                tv_count.setText("투표수 : "+String.valueOf(score.getTotalScore())+"회");
            }
        }
    }
}
