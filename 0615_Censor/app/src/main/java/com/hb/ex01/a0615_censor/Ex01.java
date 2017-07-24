package com.hb.ex01.a0615_censor;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import java.util.List;

/**
 * Created by HB04-03 on 2017-06-15.
 */

public class Ex01 extends Activity{
    TextView tv1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex01);
        tv1 = (TextView)findViewById(R.id.tv1);

        // Sensor는 SensorManager 활용
        SensorManager sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        List<Sensor> sensors = sm.getSensorList(Sensor.TYPE_ALL);
        String report = "전체 센서의 수 : "+sensors.size()+"\n";
        for(Sensor k : sensors){
            report += "sensor name : "+k.getName()+
                    "\npower : "+k.getPower()+                  // 단위
                    "\nres : "+k.getResolution()+               // 해상도
                    "\nrange : "+k.getMaximumRange()+           // 최대범위
                    "\n::::::::::::::::::::::::::::::::::::\n";
        }
        tv1.setText(report);
    }
}
