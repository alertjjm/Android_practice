package com.example.samplejavatread;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.nio.charset.Charset;

public class MainActivity extends AppCompatActivity {
    Button requestBtn;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.textView);
        requestBtn=(Button)findViewById(R.id.requestBtn);
        requestBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                request();
            }
        });
    }
    private void request(){
        String title="원격 요청";
        String message="데이터를 요청하시겠습니까?";
        String titleButtonYes="예";
        String titleButtonNo="아니오";
        AlertDialog dialog=makeRequestDialog(title,message,titleButtonYes,titleButtonNo);
        dialog.show();
        textView.setText("원격 데이터 요청중 ...");
    }
    private AlertDialog makeRequestDialog(CharSequence title, CharSequence message, CharSequence titleButtonYes, CharSequence titleButtonNo){
        AlertDialog.Builder requestDialog=new AlertDialog.Builder(this);
        requestDialog.setTitle(title);
        requestDialog.setMessage(message);
        requestDialog.setPositiveButton(titleButtonYes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                RequestHandler handler=new RequestHandler();
                handler.sendEmptyMessageDelayed(0,20);
            }
        });
        requestDialog.setNegativeButton(titleButtonNo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        return requestDialog.show();
    }
    class RequestHandler extends Handler{
        public void handleMessage(Message msg){
            for(int k=0; k<10; k++){
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException ex){}
            }
            textView.setText("원격 데이터 요청 완료.");
        }
    }
}
