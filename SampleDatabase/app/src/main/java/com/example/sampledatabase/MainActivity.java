package com.example.sampledatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button createDatabaseBtn;
    Button createTableBtn;
    EditText databaseNameInput;
    EditText tableNameInput;
    String databaseName;
    String tableName;
    TextView status;
    boolean databaseCreated = false;
    boolean tableCreated = false;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createDatabaseBtn=(Button)findViewById(R.id.createDatabaseBtn);
        createTableBtn=(Button)findViewById(R.id.createTableBtn);
        databaseNameInput=(EditText)findViewById(R.id.databaseNameInput);
        tableNameInput=(EditText)findViewById(R.id.tableNameInput);
        status=(TextView)findViewById(R.id.status);
        createDatabaseBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                databaseName=databaseNameInput.getText().toString();
                createDatabase(databaseName);
            }
        });
        createTableBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                tableName=tableNameInput.getText().toString();
                createTable(tableName);
                int count=insertRecord(tableName);
                println(count+" recordss inserted.");
            }
        });
    }
    private void createDatabase(String name){
        println("creating database [" + name+"].");
        db=openOrCreateDatabase(name,MODE_PRIVATE,null);
        databaseCreated=true;
    }
    private void createTable(String name){
        println("creating table ["+name+"].");
        db.execSQL("create table if not exists "+name+"("+" _id integer PRIMARY KEY autoincrement, name text, age integer, phone text)");
        tableCreated=true;
    }
    private int insertRecord(String name){
        println("inserting records");
        int count=3;
        db.execSQL( "insert into " + name + "(name, age, phone) values ('John', 20, '010-7788-1234');" );
        db.execSQL( "insert into " + name + "(name, age, phone) values ('Mike', 35, '010-8888-1111');" );
        db.execSQL( "insert into " + name + "(name, age, phone) values ('Sean', 26, '010-6677-4321');" );
        return count;
    }
    private void println(String msg) {
        Log.d("MainActivity", msg);
        status.append("\n" + msg);
    }

}
