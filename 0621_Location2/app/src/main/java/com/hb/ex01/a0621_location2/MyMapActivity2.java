package com.hb.ex01.a0621_location2;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;

/**
 * Created by HB04-03 on 2017-06-21.
 */

public class MyMapActivity2 extends Activity{
    LocationManager lm;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            return;
        }
        Location location = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        double lat = location.getLatitude();    // 위도
        double log = location.getLongitude();   // 경도
        Uri uri = Uri.parse("google.streetview:cbll="+lat+","+log);
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            return;
        }
        lm.removeUpdates(new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                double lat = location.getLatitude();    // 위도
                double log = location.getLongitude();   // 경도
//              Uri uri = Uri.parse("geo:"+lat+","+log+",z=19");    // z = 줌
                Uri uri = Uri.parse("geo:"+lat+","+log+",z=19");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
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
}
