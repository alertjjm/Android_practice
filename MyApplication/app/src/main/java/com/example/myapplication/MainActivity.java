package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

import java.io.StreamCorruptedException;

public class MainActivity extends AppCompatActivity {
    ScrollView scrollView;
    ScrollView scrollView2;
    ImageView imageView7;
    ImageView imageView8;
    int check=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView7=(ImageView)findViewById(R.id.imageView7);
        imageView8=(ImageView)findViewById(R.id.imageView8);
        scrollView=(ScrollView)findViewById(R.id.scrollView);

        scrollView.setHorizontalScrollBarEnabled(true);
        scrollView.setVerticalScrollBarEnabled(true);
        scrollView2=(ScrollView)findViewById(R.id.scrollView2);

        scrollView2.setHorizontalScrollBarEnabled(true);
        scrollView2.setVerticalScrollBarEnabled(true);

    }
    public void buttonupclicked(View V){
        changeimage();
    }
    public void buttondownclicked(View V){
        changeimage();
    }
    public void changeimage(){
        if(check==1){
        imageView7.setImageResource(R.drawable.afaf);
        imageView8.setImageResource(R.drawable.a298);
        check=0;
        }
        else if(check==0){
            imageView8.setImageResource(R.drawable.afaf);
            imageView7.setImageResource(R.drawable.a298);
            check=1;
        }
    }

}
