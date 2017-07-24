package com.hb.ex01.a0530_homework;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by HB04-03 on 2017-05-30.
 */

public class Homework extends Activity{
    CheckBox chkbox;
    RadioGroup radioGroup;
    Button startButton;
    ImageView imageView;
    LinearLayout visibleLayout;
    String photo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homework);
        chkbox = (CheckBox)findViewById(R.id.chkbox_start);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup_photo);
        startButton = (Button)findViewById(R.id.start_button);
        imageView = (ImageView)findViewById(R.id.imageView);
        visibleLayout = (LinearLayout)findViewById(R.id.layout_visible);
        visibleLayout.setVisibility(View.INVISIBLE);
        photo="";

        chkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    visibleLayout.setVisibility(View.VISIBLE);
                }else{
                    visibleLayout.setVisibility(View.INVISIBLE);
                    radioGroup.clearCheck();
                    imageView.setImageResource(0);
                    photo="";
                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.rb_boy:
                        photo = "boy";
                        break;
                    case R.id.rb_coffee:
                        photo = "coffee";
                        break;
                    case R.id.rb_dog:
                        photo = "dog";
                        break;
                    case R.id.rb_donald:
                        photo = "donald";
                        break;
                }
            }
        });
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(photo.equals("")){
                    Toast.makeText(Homework.this, "사진을 선택하십시오.", Toast.LENGTH_SHORT).show();
                }else {
                    switch (photo) {
                        case "boy":
                            imageView.setImageResource(R.drawable.boy);
                            break;
                        case "coffee":
                            imageView.setImageResource(R.drawable.coffe);
                            break;
                        case "dog":
                            imageView.setImageResource(R.drawable.dog);
                            break;
                        case "donald":
                            imageView.setImageResource(R.drawable.donald);
                            break;
                    }
                }
            }
        });
    }
}
