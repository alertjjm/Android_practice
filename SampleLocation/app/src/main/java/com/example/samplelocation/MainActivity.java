package com.example.samplelocation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Double latitude;
    Double longitude;
    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        textView=(TextView)findViewById(R.id.textView);
        checkPermission();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLocationService();
                textView.setText("내 위치 : Latitude: "+latitude+" Longitude: "+longitude);
            }
        });
    }

    private void startLocationService() {
        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        checkPermission();
        Location location = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        latitude=location.getLatitude();
        longitude=location.getLongitude();
    }
    private void checkPermission() {
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                || checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)) {
                // Explain to the user why we need to write the permission.
                Toast.makeText(this, "Access location required", Toast.LENGTH_SHORT).show();
            }

            requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION},200);

            // MY_PERMISSION_REQUEST_STORAGE is an
            // app-defined int constant

        }else{
        }
    }
}
