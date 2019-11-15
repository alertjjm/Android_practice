package com.example.sampleprogress;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ProgressDialog dialog;
    ProgressBar progressBar;
    int gauge=10;
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
    class Endthread extends Thread{
        public void run(){
            while (true){
            if(gauge==100){
            Toast.makeText(MainActivity.this,"로딩이 완료되었습니다.",Toast.LENGTH_LONG);
            break;}
        }}
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

    @Override
    protected void onResume() {
        super.onResume();
        Backthread backthread=new Backthread();
        Endthread endthread=new Endthread();
        backthread.start();
        endthread.start();
    }
}
