package com.example.paintboard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperColors;
import android.app.WallpaperManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GoodPaintBoardActivity extends AppCompatActivity {
    Button colorBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colorBtn=(Button)findViewById(R.id.colorBtn);
        colorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorPaletteDialog.listener=new
            }
        });
    }
}
