package com.hb.ex01.a0621_location;

/**
 * Created by HB04-03 on 2017-06-21.
 */

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class LocationActivity extends Activity{
    TextView tv1, tv2, tv3;
    // 위치정보객체
    LocationManager lm ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_view);

        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv3 = (TextView)findViewById(R.id.tv3);

        lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
    }

    // 위치 수신을 시작
    @Override
    protected void onResume() {
        super.onResume();
        // 현재 사용가능한 하드웨어 이름 얻기
        // LocationManager.GPS_PROVIDER // GPS
        // LocationManager.NETWORK_PROVIDER //인터넷

        // 해당 장치가 마지막으로 수신한 위치 얻기
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED){
            return;
        }
        // Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER)
        Location location = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        // if(location != null){ onLocationChanged(location);  }

        // 위치 정보 취득
        lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 400, 0, new LocationListener() {
            // 지정된 시간, 거리마다 한번씩 호출 된다.
            @Override
            public void onLocationChanged(Location location) {
                double lat = location.getLatitude();  // 위도
                double log = location.getLongitude();  // 경도

                tv1.setText(String.valueOf(lat));
                tv2.setText(String.valueOf(log));
                tv3.setText(getAddress(lat,log));
            }
            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
            }
            @Override
            public void onProviderEnabled(String provider) {
            }
            @Override
            public void onProviderDisabled(String provider) {
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        lm.removeUpdates(new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                double lat = location.getLatitude();  // 위도
                double log = location.getLongitude();  // 경도

                tv1.setText(String.valueOf(lat));
                tv2.setText(String.valueOf(log));
                tv3.setText(getAddress(lat,log));
            }
            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
            }
            @Override
            public void onProviderEnabled(String provider) {
            }
            @Override
            public void onProviderDisabled(String provider) {
            }
        });
    }
    // 위도와 경도를 받아서 주소를 리턴
    public String getAddress(double lat, double log){
        String addrees = null;
        // 구글에서 제공하는 위치정보를 활용하기 위한 구글 API
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        List<Address> list = null;
        try{
            list = geocoder.getFromLocation(lat,log,1);
            if(list.size()>0){
                Address addr = list.get(0);
                addrees = addr.getCountryName()+""+  // 나라
                        addr.getAdminArea()+""+    // 시
                        addr.getLocality()+""+     // 구
                        addr.getThoroughfare()+""+     // 동
                        addr.getFeatureName();     // 번지
            }else{
                addrees =" 주소 찾기 실패" ;
            }
        }catch (Exception e){
        }
        return addrees;
    }
}
