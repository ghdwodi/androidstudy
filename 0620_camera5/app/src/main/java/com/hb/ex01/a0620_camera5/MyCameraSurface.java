package com.hb.ex01.a0620_camera5;

import android.content.Context;
import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.List;

/**
 * Created by HB04-03 on 2017-06-20.
 */

public class MyCameraSurface extends SurfaceView implements SurfaceHolder.Callback{
    Context context;
    SurfaceHolder holder;
    Camera camera;
    int facing;

    public MyCameraSurface(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        holder = getHolder();
        holder.addCallback(this);
        facing = Camera.CameraInfo.CAMERA_FACING_BACK;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        camera = Camera.open();
        // 카메라 초기값 지정
        Camera.Parameters parameters = camera.getParameters();
        parameters.set("jpeg-quality",70);
        parameters.setPictureFormat(ImageFormat.JPEG);
        // parameters.setPictureSize(640,480);
        camera.setParameters(parameters);

        try {
            camera.setPreviewDisplay(holder);
        }catch (Exception e){
            camera.release();
            camera = null;
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        if(holder.getSurface()==null){return;}
        try {
            camera.stopPreview();
            camera.setPreviewDisplay(holder);
            camera.startPreview();
        }catch (Exception e2){
            camera.stopPreview();
            camera.release();
            camera = null;
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if(camera!=null){
            camera.stopPreview();
            camera.release();
            camera = null;
        }
    }
}
