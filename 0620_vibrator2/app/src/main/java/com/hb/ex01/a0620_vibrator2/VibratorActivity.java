package com.hb.ex01.a0620_vibrator2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;

/**
 * Created by HB04-03 on 2017-06-20.
 */

public class VibratorActivity extends Activity{
    EditText editText;
    ToggleButton btn_toggle;
    Button btn_vibe,btn_sos;
    int dot = 200;
    int dash = 500;
    int short_gap = 200;
    int medium_gap = 500;
    int long_gap = 1000;
    long[] pattern = {
            0,  // 즉시 시작
            dot,short_gap,dot,short_gap,dot,medium_gap,dash,short_gap,dash,short_gap,dash,
            medium_gap,dot,short_gap,dot,short_gap,dot,long_gap
    };
    int vibelength = 0;
    Vibrator vibrator;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vibrator);
        editText = (EditText)findViewById(R.id.editText);
        btn_toggle = (ToggleButton)findViewById(R.id.btn_toggle);
        btn_vibe = (Button)findViewById(R.id.btn_vibe);
        btn_sos = (Button)findViewById(R.id.btn_sos);

        vibelength = 2000;

        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

        btn_vibe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String et_vibelength = editText.getText().toString().trim();
                if(!TextUtils.isEmpty(et_vibelength)){
                    vibelength = Integer.parseInt(et_vibelength)*1000;
                    editText.setText("");
                    InputMethodManager im = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    im.hideSoftInputFromWindow(v.getWindowToken(),0);
                }
                vibrator.vibrate(vibelength);
            }
        });
        btn_sos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(pattern,-1);   // -1 : 1회만
            }
        });
        btn_toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    vibrator.vibrate(new long[]{300,100},0);
                }else{
                    vibrator.cancel();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(vibrator!=null) {
            vibrator.cancel();
        }
    }
}
