package com.example.dojun06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText2;
    EditText editText3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText2=(EditText)findViewById(R.id.editText2);
        editText3=(EditText)findViewById(R.id.editText3);
    }
    public void LoginbuttonClicked(View v){
        String id=editText2.getText().toString();
        String passwd=editText3.getText().toString();
        if(id.length()==0){
            Toast.makeText(this,"아이디를 입력하세요.",Toast.LENGTH_LONG).show();
        }
        else if(passwd.length()==0){
            Toast.makeText(this,"비밀번호를 입력하세요.",Toast.LENGTH_LONG).show();
        }
        else{
            Intent intent=new Intent(getApplicationContext(), MenuActivity.class);
            intent.putExtra("id",id);
            intent.putExtra("passwd",passwd);
            startActivity(intent);
            finish();
        }
    }
}
