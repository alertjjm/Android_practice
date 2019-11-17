package com.example.sampleweb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.webkit.JavascriptInterface;
public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button loadButton=(Button)findViewById(R.id.loadButton);
        webView=(WebView)findViewById(R.id.webView);
        final EditText urlInput=(EditText)findViewById(R.id.urlInput);
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebBrowserClient());
        webView.addJavascriptInterface(new JavaScriptMethods(),"sample");
        webView.loadUrl("file://android_asset/www/sample.html");
        loadButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                webView.loadUrl(urlInput.getText().toString());
            }
        });
    }
    final class JavaScriptMethods{
        JavaScriptMethods(){}


        public void

    }
}
