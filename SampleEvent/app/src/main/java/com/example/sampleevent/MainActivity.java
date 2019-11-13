package com.example.sampleevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.textView);
        scrollView=(ScrollView)findViewById(R.id.scrollView);
        scrollView.setVerticalScrollBarEnabled(true);

        View view=(View)findViewById(R.id.view);
        view.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action=event.getAction();
                float curx=event.getX();
                float cury=event.getY();
                if(action==event.ACTION_DOWN){
                    println("손가락 눌림 : "+curx+", "+cury);
                    scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                }else if(action==event.ACTION_MOVE){
                    println("손가락 움직임 : "+curx+", "+cury);
                    scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                }else if(action==event.ACTION_UP){
                    println("손가락 뗌 : "+curx+", "+cury);
                    scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                }
                return true;
            }
        });
    }
    public void println(String data){
        textView.append(data+"\n");
    }
}
