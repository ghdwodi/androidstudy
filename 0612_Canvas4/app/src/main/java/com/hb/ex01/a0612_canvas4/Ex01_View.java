package com.hb.ex01.a0612_canvas4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

/**
 * Created by HB04-03 on 2017-06-12.
 */

public class Ex01_View extends View{
    Context context;
    Drawable image;
    ScaleGestureDetector sgd;
    float scale = 1.0f;
    public Ex01_View(Context context) {
        super(context);
        this.context = context;
        image = context.getResources().getDrawable(R.mipmap.ic_launcher,null);  // 레벨21 이상
        setFocusable(true);
        image.setBounds(0,0,image.getIntrinsicWidth(),image.getIntrinsicHeight());
        sgd = new ScaleGestureDetector(context,new ScaleGestureDetector.SimpleOnScaleGestureListener(){
            @Override
            public boolean onScale(ScaleGestureDetector detector) {
                scale *= sgd.getScaleFactor();
                if(scale<0.1f){
                    scale = 0.1f;
                }
                if(scale>10.0f){
                    scale = 10.0f;
                }
                invalidate();
                return true;
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.scale(scale,scale);
        image.draw(canvas);
        canvas.restore();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        sgd.onTouchEvent(event);
        invalidate();
        return true;
    }
}
