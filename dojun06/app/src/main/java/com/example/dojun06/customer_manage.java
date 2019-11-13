package com.example.dojun06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class customer_manage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_manage);
    }
    public void gotomenuclicked(View v){
        Intent intent=new Intent(getApplicationContext(), MenuActivity.class);
        startActivity(intent);
        finish();
    }
    public void gotologinclicked(View v){
        Intent intent=new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }
}
