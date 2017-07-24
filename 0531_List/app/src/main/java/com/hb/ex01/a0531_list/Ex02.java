package com.hb.ex01.a0531_list;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by HB04-03 on 2017-05-31.
 */

public class Ex02 extends Activity{
    EditText editText;
    Button button,button2;
    ListView list3;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    String msg;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex02);

        editText = (EditText)findViewById(R.id.editText);
        button = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        list3 = (ListView)findViewById(R.id.list3);

        list = new ArrayList<>();
        list.add("망고");

        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                list
        );

        list3.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().length()==0){
                    Toast.makeText(Ex02.this, "항목을 입력하십시오.", Toast.LENGTH_SHORT).show();
                }else{
                    list.add(editText.getText().toString());
                    editText.setText("");
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().length()==0){
                    Toast.makeText(Ex02.this, "항목을 입력하십시오.", Toast.LENGTH_SHORT).show();
                }else{
                    list.remove(editText.getText().toString());
                    editText.setText("");
                }
            }
        });
    }
}
