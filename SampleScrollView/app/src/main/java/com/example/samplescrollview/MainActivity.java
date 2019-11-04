package com.example.samplescrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {
    ScrollView scrollView;
    ImageView imageView;
    BitmapDrawable bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scrollView=(ScrollView)findViewById(R.id.scrollView);
        imageView=(ImageView)findViewById(R.id.imageView);
        //scrollView.setHorizontalFadingEdgeEnabled(true);
        Resources res=getResources();
        bitmap=(BitmapDrawable)res.getDrawable(R.drawable.k_20190522_195846948);
        int bitmapWidth=bitmap.getIntrinsicWidth();
        int bitmapHeight=bitmap.getIntrinsicHeight();
        imageView.setImageDrawable(bitmap);
        imageView.getLayoutParams().width=bitmapWidth;
        imageView.getLayoutParams().height=bitmapHeight;
    }
    public void onButton1Clicked(View V){
        changeImage();
    }
    private void changeImage(){
        Resources res=getResources();
        bitmap=(BitmapDrawable)res.getDrawable(R.drawable.kalk_20190115_144742378);
        int bitmapWidth=bitmap.getIntrinsicWidth();
        int bitmapHeight=bitmap.getIntrinsicHeight();
        imageView.setImageDrawable(bitmap);
        imageView.getLayoutParams().width=bitmapWidth;
        imageView.getLayoutParams().height=bitmapHeight;
    }

}
