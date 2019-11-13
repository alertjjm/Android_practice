package com.example.dojun06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Intent intent=getIntent();
        if(intent.getExtras()!=null) {
            String id = intent.getExtras().getString("id");
            Toast.makeText(this, id + "님 환영합니다!", Toast.LENGTH_LONG).show();
        }
    }
    public void cmbuttonclicked(View v){
        Intent intent=new Intent(getApplicationContext(), customer_manage.class);
        startActivity(intent);
        finish();
    }
    public void pmbuttonclicked(View v){
        Intent intent=new Intent(getApplicationContext(), product_manage.class);
        startActivity(intent);
        finish();
    }
    public void smbuttonclicked(View v){
        Intent intent=new Intent(getApplicationContext(), sales_manage.class);
        startActivity(intent);
        finish();
    }
}
