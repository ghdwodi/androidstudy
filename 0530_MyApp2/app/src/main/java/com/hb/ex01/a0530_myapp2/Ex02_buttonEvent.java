package com.hb.ex01.a0530_myapp2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by HB04-03 on 2017-05-30.
 */

public class Ex02_buttonEvent extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01_buttonevent);

        Button btn = (Button)findViewById(R.id.button1);
        EventTest eventTest = new EventTest();
        btn.setOnClickListener(eventTest);
    }

    class EventTest implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            TextView tv1 = (TextView)findViewById(R.id.textView1);
            EditText et1 = (EditText)findViewById(R.id.editText1);

            tv1.setText(et1.getText());
        }
    }
}

