package com.example.smaplepush;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    TextView textView2;
    String newToken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(this, new OnSuccessListener<InstanceIdResult>() {
            @Override
            public void onSuccess(InstanceIdResult result) {
                newToken = result.getToken();
            }
        });
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String instanceId = FirebaseInstanceId.getInstance().getId();
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            processIntent(intent);
        }
        super.onNewIntent(intent);
    }
    public void println(String data) {
        textView2.append(data + "\n");
        Log.d("FMS", data);
    }
    private void processIntent(Intent intent) {
        String from = intent.getStringExtra("from");
        if (from == null) {
            return;
        }

        String contents = intent.getStringExtra("contents");
        textView.setText("수신한 데이터 : " + contents);
    }
}
