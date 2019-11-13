package com.example.sampleevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.textView);
        ScrollView scrollView=(ScrollView)findViewById(R.id.scrollView);
        scrollView.setVerticalScrollBarEnabled(true);
        scrollView.fullScroll(ScrollView.FOCUS_DOWN);
        View view=(View)findViewById(R.id.view);
        view.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action=event.getAction();
                float curx=event.getX();
                float cury=event.getY();
                if(action==event.ACTION_DOWN){
                    println("손가락 눌림 : "+curx+", "+cury);
                }else if(action==event.ACTION_MOVE){
                    println("손가락 움직임 : "+curx+", "+cury);
                }else if(action==event.ACTION_UP){
                    println("손가락 뗌 : "+curx+", "+cury);
                }
                return true;
            }
        });
    }
    public void println(String data){
        textView.append(data+"\n");
    }
}
