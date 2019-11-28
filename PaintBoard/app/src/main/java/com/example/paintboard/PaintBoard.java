package com.example.paintboard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class PaintBoard extends View {
    Paint mPaint;
    Canvas cacheCanvas;
    Bitmap mBitmap;
    int lastX,lastY;
    public PaintBoard(Context context) {
        super(context);
        mPaint=new Paint();
        mPaint.setColor(Color.BLACK);
        lastX=-1;
        lastY=-1;

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action=event.getAction();
        int X=(int)event.getX();
        int Y=(int)event.getY();
        switch (action){
            case MotionEvent.ACTION_UP:
                lastX=-1;
                lastY=-1;
                break;
            case MotionEvent.ACTION_DOWN:
                if(lastX!=-1){
                    if(X!=lastX||Y!=lastY)
                        cacheCanvas.drawLine(lastX,lastY,X,Y,mPaint);
                }
                lastX=X;
                lastY=Y;
                break;
            case MotionEvent.ACTION_MOVE:
                if(lastX!=-1){
                    cacheCanvas.drawLine(lastX,lastY,X,Y,mPaint);

                }
                lastY=Y;
                lastX=X;
                break;
        }
        invalidate();
        return true;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        Bitmap img = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas();
        canvas.setBitmap(img);
        canvas.drawColor(Color.WHITE);
        mBitmap = img;
        cacheCanvas = canvas;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mBitmap != null) {
            canvas.drawBitmap(mBitmap, 0, 0, null);
        }
    }
    public void setColor(int Color){
        mPaint.setColor(Color);
    }
    public void setLineWidth(float lineWidth){
        mPaint.setStrokeWidth(lineWidth);
    }
}
