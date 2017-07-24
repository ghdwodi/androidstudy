package com.hb.ex01.a0609_canvas2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by HB04-03 on 2017-06-09.
 */

public class Ex01_View extends View{
    Context context;
    int x = -10;
    int y = -10;
    String str;
    public Ex01_View(Context context) {
        super(context);
        this.context = context;
        setBackgroundColor(Color.argb(180,204,255, 255));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(100);
        canvas.drawText("x="+x+", y="+y+" "+str,0,100,paint);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(x,y,100,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = (int)event.getX();
        y = (int)event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                str = "down";break;
            case MotionEvent.ACTION_MOVE:
                str = "move";break;
            case MotionEvent.ACTION_UP:
                str = "up";break;
        }
        invalidate();
        return true;
    }
}
