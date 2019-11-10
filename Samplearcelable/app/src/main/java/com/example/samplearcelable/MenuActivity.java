package com.example.samplearcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    TextView textView;
    public static final String KEY_SIMPLE_DATA="data";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        textView=(TextView)findViewById(R.id.textView);
        Button button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent=new Intent();
                intent.putExtra("name","mike");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
        Intent intent= getIntent();
        processIntent(intent);
    }
    private void processIntent(Intent intent){
        if(intent!=null){
            Bundle bundle=intent.getExtras();
            SimpleData data=(SimpleData)bundle.getParcelable(KEY_SIMPLE_DATA);
            textView.setText("전달받은데이터\nNumber : "+data.number+"\nMessage : "+data.message);
        }
    }

}
