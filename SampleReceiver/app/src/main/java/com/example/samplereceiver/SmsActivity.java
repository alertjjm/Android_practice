package com.example.samplereceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SmsActivity extends AppCompatActivity {
    EditText editText5;
    EditText editText6;
    EditText editText7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        editText5=(EditText)findViewById(R.id.editText5);
        editText6=(EditText)findViewById(R.id.editText6);
        editText7=(EditText)findViewById(R.id.editText7);
        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent passedIntent=getIntent();
        processIntent(passedIntent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        processIntent(intent);
        super.onNewIntent(intent);
    }
    private void processIntent(Intent intent){
        if(intent!=null){
            String sender=intent.getStringExtra("sender");
            String contents=intent.getStringExtra("contents");
            String receivedDate=intent.getStringExtra("receivedDate");
            editText5.setText(sender);
            editText6.setText(contents);
            editText7.setText(receivedDate);
        }
    }

}
