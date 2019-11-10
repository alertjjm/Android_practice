package com.example.samplelifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),"onStart호출됨",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),"onStop호출됨",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"onDestroy호출됨",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),"onPause호출됨",Toast.LENGTH_LONG).show();
        saveState();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),"onResume호출됨",Toast.LENGTH_LONG).show();
        restoreState();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.editText);
        Toast.makeText(getApplicationContext(),"onCreate호출됨",Toast.LENGTH_LONG).show();
    }
    protected void restoreState(){
        SharedPreferences pref=getSharedPreferences("pref",Activity.MODE_PRIVATE);
        if((pref!=null)&&(pref.contains("name"))){
            String name=pref.getString("name","");
            editText.setText(name);
        }
    }
    protected void saveState(){
        SharedPreferences pref=getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        editor.putString("name",editText.getText().toString());
        editor.commit();
    }
}
