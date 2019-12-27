package com.example.samplehttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    EditText input01;
    Button requestBtn;
    TextView txtMsg;
    public static String defaultUrl="http://m.naver.com";
    Handler handler=new Handler();
    class ConnectThread extends Thread{
        String urlStr;
        public ConnectThread(String inStr){
            urlStr=inStr;
        }
        public void run(){
            try{
                final String output=request(urlStr);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        txtMsg.setText(output);
                    }
                });
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        private String request(String urlStr){
            StringBuilder output=new StringBuilder();
            try{
                URL url=new URL(urlStr);
                HttpsURLConnection con=(HttpsURLConnection)url.openConnection();
                if(con!=null){
                    con.setConnectTimeout(10000);
                    con.setRequestMethod("GET");
                    con.setDoInput(true);
                    con.setDoOutput(true);
                    int resCode=con.getResponseCode();
                    BufferedReader reader=new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String line=null;
                    while(true){
                        line=reader.readLine();
                        if(line==null){
                            break;
                        }
                        output.append(line+"\n");

                    }
                    reader.close();
                    con.disconnect();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return output.toString();
        }
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestBtn=(Button)findViewById(R.id.requestBtn);
        txtMsg=(TextView)findViewById(R.id.txtMsg);
        input01=(EditText)findViewById(R.id.input01);
        requestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlStr = input01.getText().toString();
                ConnectThread thread = new ConnectThread(urlStr);
                thread.start();
            }
        });
    }
}
