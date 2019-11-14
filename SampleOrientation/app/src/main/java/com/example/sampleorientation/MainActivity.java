package com.example.sampleorientation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String name;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=(EditText)findViewById(R.id.editText);
        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                name=editText.getText().toString();
                showToast("입력된 값을 변수에 저장했습니다 : "+name);
            }
        });
        if(savedInstanceState!=null){
            name=savedInstanceState.getString("name");
            Toast.makeText(this,"값을 복원했습니다 : "+name,Toast.LENGTH_LONG).show();
        }
    }
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString("name",name);
    }

    public void showToast(String data){
        Toast.makeText(this,data,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart(){
        super.onStart();

    }
    protected void onStop(){
        super.onStop();

    }
    protected void onDestroy(){
        super.onDestroy();

    }

}
