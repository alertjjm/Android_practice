package com.example.dojun18;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class booklistview extends LinearLayout {
    TextView textView;
    TextView textView2;
    ImageView imageView;
    public booklistview(Context context){
        super(context);
        init(context);
    }
    public booklistview(Context context, AttributeSet attrs){
        super(context,attrs);
        init(context);
    }
    public void init(Context context){
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.booklist,this,true);
        textView=(TextView)findViewById(R.id.textView);
        textView2=(TextView)findViewById(R.id.textView2);
        imageView=(ImageView)findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.bookicon);
    }

    public void setTextView(String bookname,int num) {
        String str=bookname+" #"+Integer.toString(num);
        textView.setText(str);
    }
    public void setTextView2(String author){
        textView2.setText(author);
    }
}
