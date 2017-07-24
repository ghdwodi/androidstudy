package com.hb.ex01.a0609_canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;

/**
 * Created by HB04-03 on 2017-06-09.
 */

// xml뷰를 대신한다. 반드시 View클래스를 상속받아야 한다.
// 기본생성자는 존재하지 않는다.
public class Ex01_View extends View{
    Context context;
    public Ex01_View(Context context) {
        super(context);
        this.context = context;
        setBackgroundColor(Color.GRAY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(10);   // 단위는 픽셀
        paint.setStrokeCap(Paint.Cap.ROUND);    // 선 끝처리
        paint.setTextSize(200);


        // 선그리기
        canvas.drawLine(100,100,300,100,paint);
        canvas.drawLine(300,100,300,300,paint);
        canvas.drawLine(300,300,100,300,paint);
        canvas.drawLine(100,300,100,100,paint);

        paint.setColor(Color.BLUE);
        canvas.drawLine(100,100,300,300,paint);
        canvas.drawLine(100,300,300,100,paint);

        paint.setColor(Color.GREEN);
        canvas.drawRect(400,100,600,300,paint);

        paint.setColor(Color.MAGENTA);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(700,100,900,300,paint);
        paint.setColor(Color.CYAN);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawRect(700,100,900,300,paint);

        paint.setColor(Color.DKGRAY);
        canvas.drawCircle(200,500,100,paint);

        paint.setColor(Color.YELLOW);
//      canvas.drawOval(380,400,620,600,paint); 레벨21 이상일 때
        canvas.drawOval(new RectF(380,400,620,600),paint);

        paint.setColor(Color.RED);
        canvas.drawText("안녕하신가",100,800,paint);

        // 그림 갖고오기
//      BitmapDrawable b = (BitmapDrawable)getResources().getDrawable(R.drawable.rabbit,null); 레벨 21이상일 때
        BitmapDrawable b = (BitmapDrawable)getResources().getDrawable(R.drawable.rabbit);
        BitmapDrawable b2 = (BitmapDrawable)getResources().getDrawable(R.drawable.test);
        Bitmap bitmap = b.getBitmap();
        Bitmap bitmap2 = b2.getBitmap();
        canvas.drawBitmap(bitmap,null,new RectF(100,1000,300,1200),paint);
        canvas.drawBitmap(bitmap2,null,new RectF(400,1000,600,1200),paint);
    }
}
