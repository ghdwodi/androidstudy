package com.hb.ex01.a0601_autocomplete;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;

/**
 * Created by HB04-03 on 2017-06-01.
 */

public class Ex01_AutoComlete extends Activity{
    AutoCompleteTextView atText;
    ArrayList<String> arrItems;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01_autocomplete);
        arrItems = new ArrayList<>();
        arrItems.add("Reader");

        atText = (AutoCompleteTextView)findViewById(R.id.atText);
        atText.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,arrItems));

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!arrItems.contains(atText.getText().toString())){
                    arrItems.add(atText.getText().toString());
                    atText.setAdapter(new ArrayAdapter<String>(Ex01_AutoComlete.this,android.R.layout.simple_dropdown_item_1line,arrItems));
                }
                atText.setText("");
            }
        });
    }
}
