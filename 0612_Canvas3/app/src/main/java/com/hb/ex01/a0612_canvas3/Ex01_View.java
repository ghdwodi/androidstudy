package com.hb.ex01.a0612_canvas3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.view.View;

/**
 * Created by HB04-03 on 2017-06-12.
 */

public class Ex01_View extends View{
    Context context;
    Bitmap bitmap;
    int x = 0;
    int y = 0;
    int nx = 20;
    int ny = 20;
    public Ex01_View(Context context) {
        super(context);
        this.context = context;
        bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        handler.sendEmptyMessageDelayed(0,200);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(x<0||(canvas.getWidth()-bitmap.getWidth())<x){
            nx = -nx;
        }
        if(y<0||(canvas.getHeight()-bitmap.getHeight())<y){
            ny = -ny;
        }
        x = x + nx;
        y = y + ny;
        canvas.drawBitmap(bitmap,x,y,null);
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            invalidate();
            handler.sendEmptyMessageDelayed(0,200);
        }
    };
}
