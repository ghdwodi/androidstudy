package com.hb.ex01.a0609_painter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by HB04-03 on 2017-06-09.
 */

public class Ex01_View extends View{
    Context context;
    Paint paint;
    Path path;
    public Ex01_View(Context context) {
        super(context);
        this.context=context;
        setBackgroundColor(Color.WHITE);
        paint = new Paint();
        path = new Path();
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x,y);return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x,y);break;
            case MotionEvent.ACTION_UP:
                break;
            default:return false;
        }
        invalidate();
        return true;
    }
}