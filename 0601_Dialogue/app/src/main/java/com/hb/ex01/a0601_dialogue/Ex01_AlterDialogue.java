package com.hb.ex01.a0601_dialogue;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

/**
 * Created by HB04-03 on 2017-06-01.
 */

public class Ex01_AlterDialogue extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01_alterdialogue);

        // 대화상자 -> AlterDialog.Builder 사용
        // 제목 설정, 메세지 설정, 아이콘 설정, OK버튼 설정, Cancel버튼 설정
        // 목록 출력, 라디오버튼, 체크박스 등

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(Ex01_AlterDialogue.this)
                        .setTitle("그냥 대화상자")
                        .setMessage("기본 대화상자")
                        .setIcon(R.mipmap.ic_launcher)
                        .show();
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(Ex01_AlterDialogue.this)
                        .setTitle("확인 대화상자")
                        .setMessage("확인 대화상자")
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Ex01_AlterDialogue.this, String.valueOf(which), Toast.LENGTH_SHORT).show();
                                Toast.makeText(Ex01_AlterDialogue.this, "대화상자2 확인", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Ex01_AlterDialogue.this, String.valueOf(which), Toast.LENGTH_SHORT).show();
                                Toast.makeText(Ex01_AlterDialogue.this, "대화상자2 취소", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setIcon(R.mipmap.ic_launcher)
                        .show();
            }
        });
        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] foods = {"맥주","소주","고량주","양주","와인"};
                new AlertDialog.Builder(Ex01_AlterDialogue.this)
                        .setTitle("라디오버튼 대화상자")
                        .setIcon(R.mipmap.ic_launcher)
                        .setSingleChoiceItems(foods, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Ex01_AlterDialogue.this, foods[which], Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] foods = {"맥주","소주","고량주","양주","와인"};
                new AlertDialog.Builder(Ex01_AlterDialogue.this)
                        .setTitle("그냥 메뉴 대화상자")
                        .setIcon(R.mipmap.ic_launcher)
                        .setItems(foods, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Ex01_AlterDialogue.this, foods[which], Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
        findViewById(R.id.btn5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] foods = {"맥주","소주","고량주","양주","와인"};
                final boolean[] chk = {false,false,false,false,false};
                new AlertDialog.Builder(Ex01_AlterDialogue.this)
                        .setTitle("복수선택 대화상자")
                        .setIcon(R.mipmap.ic_launcher)
                        .setMultiChoiceItems(foods, chk, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                if(isChecked){
                                    Toast.makeText(Ex01_AlterDialogue.this, foods[which]+" 선택", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(Ex01_AlterDialogue.this, foods[which]+" 해제", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .show();
            }
        });
    }
}
