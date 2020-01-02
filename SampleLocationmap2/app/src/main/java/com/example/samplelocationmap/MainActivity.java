package com.example.samplelocationmap;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {
    private static final String TAG="MainActivity";
    SupportMapFragment mapFragment;
    GoogleMap map;
    Location location2;
    Button button;
    Double latitude;
    Double longitude;
    MarkerOptions myLocationMarker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermission();
        mapFragment=(SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map=googleMap;
            }
        });
        try{
            MapsInitializer.initialize(this);
        }catch (Exception e){
        }
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                requestMyLocation();
                showCurrentLocation(location2);
            }
        });

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
    private class GPSListener implements LocationListener {
        @Override
        public void onLocationChanged(Location location) {
            location2=location;
            showCurrentLocation(location);
            showMyLocationMarker(location);
        }
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }
        @Override
        public void onProviderEnabled(String provider) {
        }
        @Override
        public void onProviderDisabled(String provider) {
        }
    }
    private void requestMyLocation(){
        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        checkPermission();
        Location location = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        location2=location;
        latitude=location.getLatitude();
        longitude=location.getLongitude();
        GPSListener gpsListener=new GPSListener();
        long minTime=10000;
        float minDistance=0;
        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER,minTime,minDistance,gpsListener);
    }

    private void showCurrentLocation(Location location) {
        LatLng curPoint = new LatLng(location.getLatitude(), location.getLongitude());

        map.animateCamera(CameraUpdateFactory.newLatLngZoom(curPoint, 18));
        showMyLocationMarker(location);
    }
    private void showMyLocationMarker(Location location){
        if(myLocationMarker==null){
            myLocationMarker=new MarkerOptions();
            myLocationMarker.position(new LatLng(location.getLatitude(),location.getLongitude()));
            myLocationMarker.title("내 위치");
            myLocationMarker.snippet("GPS로 확인한 위치");
            myLocationMarker.icon(BitmapDescriptorFactory.fromResource(R.drawable.mylocation));
            myLocationMarker.draggable(true);
            map.addMarker(myLocationMarker);
        }else{
            map.clear();
            myLocationMarker.visible(false);
            myLocationMarker=new MarkerOptions();
            myLocationMarker.position(new LatLng(location.getLatitude(),location.getLongitude()));
            myLocationMarker.title("내 위치");
            myLocationMarker.snippet("GPS로 확인한 위치");
            myLocationMarker.icon(BitmapDescriptorFactory.fromResource(R.drawable.mylocation));
            map.addMarker(myLocationMarker);
        }
    }
}
