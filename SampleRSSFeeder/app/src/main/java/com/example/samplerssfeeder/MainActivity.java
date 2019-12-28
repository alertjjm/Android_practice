package com.example.samplerssfeeder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static String rssUrl="http://api.sbs.co.kr/xml/news/rss.jsp?pmDiv=entertainment";

    ArrayList<RSSNewsItem> newsItemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
