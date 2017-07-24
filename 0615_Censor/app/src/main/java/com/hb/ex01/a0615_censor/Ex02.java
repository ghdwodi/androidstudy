package com.hb.ex01.a0615_censor;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Created by HB04-03 on 2017-06-15.
 */

public class Ex02 extends Activity implements SensorEventListener{
    TextView tv_acc,tv_gravity,tv_rotate,tv_light,tv_magnetic,tv_near,tv_hot;
    SensorManager sensorManager;
    SensorEventListener tv_accL,tv_gravityL,tv_rotateL,tv_lightL,tv_magneticL,tv_nearL,tv_hotL;
    Sensor tv_accS,tv_gravityS,tv_rotateS,tv_lightS,tv_magneticS,tv_nearS,tv_hotS;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex02);

        tv_acc = (TextView)findViewById(R.id.tv_acc);
        tv_gravity = (TextView)findViewById(R.id.tv_gravity);
        tv_rotate = (TextView)findViewById(R.id.tv_rotate);
        tv_light = (TextView)findViewById(R.id.tv_light);
        tv_magnetic = (TextView)findViewById(R.id.tv_magnetic);
        tv_near = (TextView)findViewById(R.id.tv_near);
        tv_hot = (TextView)findViewById(R.id.tv_hot);

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        tv_accS = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        tv_gravityS = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        tv_rotateS = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        tv_lightS = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        tv_magneticS = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        tv_nearS = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        tv_hotS = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        // 동기화 처리(여러 센서가 동시에 접근하므로)
        synchronized (this){
            float v1 = event.values[0]; // 방위각(X) : 0=북, 90=동, 180=남, 270=서
            float v2 = event.values[1]; // 피치(Y) : 0=수평, -90=수직, 90=수직(거꾸로)
            float v3 = event.values[2]; // 롤(Z) : 0=바닥, -90= 왼쪽, 90=오른쪽

            switch (event.sensor.getType()){
                case Sensor.TYPE_ACCELEROMETER:
                    tv_acc.setText("x="+v1+", y="+v2+", z="+v3);
                    break;
                case Sensor.TYPE_GRAVITY:
                    tv_gravity.setText("x="+v1+", y="+v2+", z="+v3);
                    break;
                case Sensor.TYPE_GYROSCOPE:
                    tv_rotate.setText("x="+v1+", y="+v2+", z="+v3);
                    break;
                case Sensor.TYPE_LIGHT:
                    tv_light.setText("x="+v1+", y="+v2+", z="+v3);
                    break;
                case Sensor.TYPE_MAGNETIC_FIELD:
                    tv_magnetic.setText("x="+v1+", y="+v2+", z="+v3);
                    break;
                case Sensor.TYPE_PROXIMITY:
                    tv_near.setText("x="+v1+", y="+v2+", z="+v3);
                    break;
                case Sensor.TYPE_AMBIENT_TEMPERATURE:
                    tv_hot.setText("x="+v1+", y="+v2+", z="+v3);
                    break;
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,tv_accS,sensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this,tv_gravityS,sensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this,tv_rotateS,sensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this,tv_lightS,sensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this,tv_magneticS,sensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this,tv_nearS,sensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this,tv_hotS,sensorManager.SENSOR_DELAY_NORMAL);
    }
}
