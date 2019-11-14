package com.example.sampleevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ScrollView scrollView;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            Toast.makeText(this,"시스템[back]버튼이 눌렸습니다.",Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final GestureDetector detector;

        detector=new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                println("onDown() 호출됨.");
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                return true;
            }

            @Override
            public void onShowPress(MotionEvent e) {
                println("onShowPress 호출됨.");
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                println("onSingleTapUp 호출됨");
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                println("onScroll 호출됨: "+distanceX+", "+distanceY);
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                println("onLogPress 호출됨");
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                println("onFling 호출됨 : "+velocityX+", "+velocityY);
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                return true;
            }
        });
        textView=(TextView)findViewById(R.id.textView);
        scrollView=(ScrollView)findViewById(R.id.scrollView);
        scrollView.setVerticalScrollBarEnabled(true);
        View view2=(View)findViewById(R.id.view2);
        View view=(View)findViewById(R.id.view);
        view2.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                detector.onTouchEvent(event);
                return true;
            }
        });
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
