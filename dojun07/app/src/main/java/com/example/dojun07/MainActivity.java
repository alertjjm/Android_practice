package com.example.dojun07;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
public class MainActivity extends AppCompatActivity {
    EditText editText;
    EditText editText2;
    TextView textView;
    TextView textView2;
    Button button;
    Button button2;
    String yeara,montha,daya;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        button2=(Button)findViewById(R.id.button2);
        textView=(TextView)findViewById(R.id.textView);
        textView2=(TextView)findViewById(R.id.textView2);
        editText=(EditText)findViewById(R.id.editText);
        editText2=(EditText)findViewById(R.id.editText2);
        //
        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat weekdayFormat = new SimpleDateFormat("EE", Locale.getDefault());
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd", Locale.getDefault());
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM", Locale.getDefault());
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy", Locale.getDefault());

        String weekDay = weekdayFormat.format(currentTime);
        yeara = yearFormat.format(currentTime);
        montha = monthFormat.format(currentTime);
        daya = dayFormat.format(currentTime);
        button.setText(yeara+"년 "+montha+" 월 "+daya+"일");
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String name=editText.getText().toString();
                String age=editText2.getText().toString();
                Toast.makeText(getApplicationContext(),"이름: "+name+" 나이: "+age+" "+yeara+"년 "+montha+"월 "+daya+"일",Toast.LENGTH_LONG).show();
            }
        });
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog=new DatePickerDialog(MainActivity.this,listener,Integer.parseInt(yeara),Integer.parseInt(montha),Integer.parseInt(daya));
                dialog.show();
            }
        });
    }
    public DatePickerDialog.OnDateSetListener listener=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
            yeara=Integer.toString(year);
            montha=Integer.toString(month);
            daya=Integer.toString(day);
            button.setText(yeara+"년 "+montha+" 월 "+daya+"일");
        }
    };
}
