package com.hb.ex01.a0614_camera3;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by HB04-03 on 2017-06-14.
 */

// SurfaceView => 더블버퍼링(화면 끊김을 없애 준다)

public class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback{
    Context context;
    private SurfaceHolder surfaceHolder;
    private Camera camera;
    public CameraSurfaceView(Context context) {
        super(context);
        this.context = context;
        // 1. SurfaceHolder 객체 얻기
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        camera = Camera.open();
        try {
            camera.setPreviewDisplay(surfaceHolder);
        }catch (Exception e){
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        camera.startPreview();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        camera.release();
        camera = null;
    }

    // 이벤트 처리할 때 캡쳐하는 메소드
    public boolean capture(Camera.PictureCallback handler){
        boolean result = false;
        if(camera!=null){
            camera.takePicture(null,null,handler);
            result = true;
        }
        return result;
    }
}