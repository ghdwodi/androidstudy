package com.hb.ex01.a0530_myapp2;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by HB04-03 on 2017-05-30.
 */

public class Ex01_buttonEvent extends Activity implements View.OnClickListener{
    TextView textView1;
    EditText editText1;
    Button button1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01_buttonevent);

        // xml에 존재하는 위젯을 자바에서 인식할 수 있도록 한다.
        textView1 = (TextView)findViewById(R.id.textView1);
//      String str = textView1.getText().toString();
//      Toast.makeText(this, str, Toast.LENGTH_SHORT).show();

//      textView1.setText("글자변경하기");

//      textView1.setTextColor(Color.CYAN);
        editText1 = (EditText)findViewById(R.id.editText1);
        button1 = (Button)findViewById(R.id.button1);

        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        textView1.setText(editText1.getText());
    }
}
