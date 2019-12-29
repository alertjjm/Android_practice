package com.example.dojun18;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    public static final String TAG = "MainActivity";
    public int num;
    private static String COPYDATA_NAME = "book_db.db";
    private static String DATABASE_NAME="book_db.db";
    public static String PACKAGE_DIR="com.example.dojun18";
    private static String TABLE_NAME = "books";
    private static int DATABASE_VERSION = 1;
    private DatabaseHelper dbHelper;
    ListView listView;
    Button buttonsave;
    EditText edittitle;
    EditText editauthor;
    EditText editdescription;
    BookAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        File folder = new File(PACKAGE_DIR + "databases");
        if (folder.exists()){


        } else {
            folder.mkdir();
        }

        File outfile = new File(PACKAGE_DIR + "databases/" + COPYDATA_NAME);

        if (outfile.length() <= 0) {
            AssetManager assetManager = this.getResources().getAssets();
            try {
                InputStream is = assetManager.open(DATABASE_NAME, AssetManager.ACCESS_BUFFER);
                long filesize = is.available();
                byte [] tempdata = new byte[(int)filesize];
                is.read();
                is.close();
                outfile.createNewFile();
                FileOutputStream fo = new FileOutputStream(outfile);
                fo.write(tempdata);
                fo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        dbHelper=new DatabaseHelper(this);
        db=dbHelper.getWritableDatabase();
        db.execSQL("create table if not exists books (num integer PRIMARY KEY, name text, author text, description text)");
        Cursor c = db.rawQuery("select * from books",null);
        num=c.getCount();
        //탭추가
        //db.execSQL("delete from books where 1=1");
        TabHost tabHost1 = (TabHost) findViewById(R.id.tabHost1) ;
        tabHost1.setup() ;

        // 첫 번째 Tab. (탭 표시 텍스트:"TAB 1"), (페이지 뷰:"content1")
        TabHost.TabSpec ts1 = tabHost1.newTabSpec("Tab Spec 1") ;
        ts1.setContent(R.id.content1) ;
        ts1.setIndicator("입력") ;
        tabHost1.addTab(ts1)  ;

        // 두 번째 Tab. (탭 표시 텍스트:"TAB 2"), (페이지 뷰:"content2")
        TabHost.TabSpec ts2 = tabHost1.newTabSpec("Tab Spec 2") ;
        ts2.setContent(R.id.content2) ;
        ts2.setIndicator("조회") ;
        tabHost1.addTab(ts2) ;

        listView=(ListView)findViewById(R.id.listView);
        buttonsave=(Button)findViewById(R.id.buttonsave);
        editauthor=(EditText)findViewById(R.id.editauthor);
        editdescription=(EditText)findViewById(R.id.editdescription);
        edittitle=(EditText)findViewById(R.id.edittitle);
        adapter=new BookAdapter();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                bookitem item=(bookitem)adapter.getItem(position);
                Toast.makeText(getApplicationContext(),item.description,Toast.LENGTH_LONG).show();
            }
        });
        buttonsave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String name=edittitle.getText().toString();
                String author=editauthor.getText().toString();
                String description=editdescription.getText().toString();
                Cursor c = db.rawQuery("select * from books",null);
                num=c.getCount();
                String sql="insert into "+TABLE_NAME+" (name, author, num, description) values ('"+name+"', '"+author+"', "+Integer.toString(num+1)+", '"+description+"')";
                db.execSQL(sql);
                bookitem bi=new bookitem(name,author,description,num+1);
                adapter.addItem(bi);
            }
        });
        Cursor f=db.rawQuery("select * from books",null);
        while(f.moveToNext()){
            bookitem tempitem=new bookitem(f.getString(f.getColumnIndex("name")),f.getString(f.getColumnIndex("author")),f.getString(f.getColumnIndex("description")),f.getInt(f.getColumnIndex("num")));
            adapter.addItem(tempitem);
        }

    }
    private class DatabaseHelper extends SQLiteOpenHelper{
        public DatabaseHelper(Context context){
            super(context,DATABASE_NAME,null,DATABASE_VERSION);
        }

        @Override
        public void onOpen(SQLiteDatabase db) {
            super.onOpen(db);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
    class BookAdapter extends BaseAdapter{

        ArrayList<bookitem> items=new ArrayList<bookitem>();
        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            booklistview view=new booklistview(getApplicationContext());
            bookitem item=items.get(position);
            view.setTextView(item.bookname,item.booknum);
            view.setTextView2(item.author);
            return view;
        }
        public void addItem(bookitem item){items.add(item);}
    }
}
