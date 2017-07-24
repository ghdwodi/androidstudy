package com.hb.ex01.a0620_camera4;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by HB04-03 on 2017-06-20.
 */

public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback{
    Context context;
    private  SurfaceHolder holder;
    Camera camera;

    public CameraPreview(Context context) {
        super(context);
        this.context = context;
        holder = getHolder();
        holder.addCallback(this);
        // 아래는 3.0 이하에서만 필요
//      holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            camera = Camera.open(); // 카메라 생성
            camera.setPreviewDisplay(holder);   // 미리보기
            camera.startPreview();
        }catch (Exception e){
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        if(holder.getSurface()==null){
            return;
        }
        try {
            camera.stopPreview();   // 미리보기 중지
            camera.setPreviewDisplay(holder);   // 미리보기 실행
            camera.startPreview();
        }catch (Exception e){
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if(camera != null){
            camera.stopPreview();
            camera.release();
            camera = null;
        }
    }
}
