package com.example.sampledatabasequery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView status;
    public static final String TAG = "MainActivity";
    private static String DATABASE_NAME = null;
    private static String TABLE_NAME = "employee";
    private static int DATABASE_VERSION = 1;
    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private class DatabaseHelper extends SQLiteOpenHelper{
        public DatabaseHelper(Context context){
            super(context,DATABASE_NAME,null,DATABASE_VERSION);
        }
    }
}
