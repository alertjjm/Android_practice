package com.example.dojun4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText2;
    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText2=(EditText)findViewById(R.id.editText2);
        textView2=(TextView)findViewById(R.id.textView2);
        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textView2.setText(s.toString().getBytes().length+" / 80 바이트");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    public void buttonclicked(View V){
        Toast toast=Toast.makeText(this,textView2.getText(),Toast.LENGTH_LONG);
        toast.show();
    }
}
