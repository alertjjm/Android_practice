package com.example.customviewdrawables;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.ShapeDrawable;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

public class CustomViewDrawables extends View {
    private ShapeDrawable upperDrawable;
    private ShapeDrawable lowerDrawable;
    public CustomViewDrawables(Context context) {
        super(context);
        WindowManager manager=(WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        Display display=manager.getDefaultDisplay();
        Point sizePoint=new Point();
        display.getSize(sizePoint);
        int width=sizePoint.x;
        int height=sizePoint.y;
        Resources curRes=getResources();
        int blackColor=curRes.getColor(R.color.color01)
    }
}
