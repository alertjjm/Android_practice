package com.example.sampleprogress;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ProgressDialog dialog;
    ProgressBar progressBar;
    int gauge=10;
    int brightness=100;
    class Backthread extends Thread{
        public void run(){
            boolean running =true;

            while (running){
                try{
                    Thread.sleep(1000);
                }catch (Exception e){}
                gauge+=5;
                progressBar.incrementProgressBy(+5);
                if(gauge==100){
                    running=false;}
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        progressBar.setIndeterminate(false);
        progressBar.setMax(100);
        progressBar.setProgress(10);
        Button button=(Button)findViewById(R.id.button);
        final TextView textView=(TextView)findViewById(R.id.textView);
        Button button3=(Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                LinearLayout seekBarPanel=(LinearLayout)findViewById(R.id.seekBarPanel);
                seekBarPanel.setVisibility(View.VISIBLE);
            }
        });
        SeekBar seekBar=(SeekBar)findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setBrightness(progress);
                textView.setText("시크바의 값 : "+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dialog=new ProgressDialog(MainActivity.this);
                dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                dialog.setMessage("데이터를 확인하는 중입니다.");
                dialog.show();
            }
        });
        Button button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(dialog!=null){
                    dialog.dismiss();
                }
            }
        });
    }
    private void setBrightness(int value){
        if(value<10){
            value=10;
        }else if(value>100){
            value=100;
        }
        brightness=value;
        WindowManager.LayoutParams params=getWindow().getAttributes();
        params.screenBrightness=(float)value/100;
        getWindow().setAttributes(params);
    }
    @Override
    protected void onResume() {
        super.onResume();
        Backthread backthread=new Backthread();

        backthread.start();

    }
}
