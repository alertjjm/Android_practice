package com.example.samplemultitouch;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class ImageDisplayView extends View implements View.OnTouchListener {
    Paint mPaint;
    Matrix mMatrix;
    Context mContext;
    Bitmap mBitmap;
    Bitmap sourceBitmap;
    int lastX;
    int lastY;
    float sourceWidth = 0.0F;
    float sourceHeight = 0.0F;

    float bitmapCenterX;
    float bitmapCenterY;

    float scaleRatio;
    float totalScaleRatio;

    float displayWidth = 0.0F;
    float displayHeight = 0.0F;

    int displayCenterX = 0;
    int displayCenterY = 0;

    public float startX;
    public float startY;

    public static float MAX_SCALE_RATIO = 5.0F;
    public static float MIN_SCALE_RATIO = 0.1F;

    float oldDistance = 0.0F;

    int oldPointerCount = 0;
    boolean isScrolling = false;
    float distanceThreshold = 3.0F;
    public ImageDisplayView(Context context) {
        super(context);

        mContext = context;

        init();
    }

    public ImageDisplayView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mContext = context;

        init();
    }

    private void init(){
        mPaint=new Paint();
        mMatrix=new Matrix();
        lastX=-1;
        lastY=-1;
        setOnTouchListener(this);
    }

    public void newImage(int width, int height){

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
