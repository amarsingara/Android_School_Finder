package com.example.schoolapplication;



import android.content.Intent;

import android.os.Bundle;



import androidx.appcompat.app.AppCompatActivity;



import com.google.android.gms.maps.CameraUpdateFactory;

import com.google.android.gms.maps.GoogleMap;

import com.google.android.gms.maps.OnMapReadyCallback;

import com.google.android.gms.maps.SupportMapFragment;


import com.google.android.gms.maps.model.LatLng;

import com.google.android.gms.maps.model.MarkerOptions;



public class MapView extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    double lon;

    double lat;







    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.map_view);

        Intent intent = this.getIntent();

        lon = intent.getDoubleExtra("lon", lon);

        lat = intent.getDoubleExtra("lat", lat);


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        CameraUpdateFactory.zoomTo(15);



    }







    @Override

    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;



        // Add a marker in Sydney, Australia, and move the camera.

        LatLng Some = new LatLng(lat, lon);


        mMap.addMarker(new MarkerOptions().position(Some).title("Marker in Sydney"));


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Some,15));









    }

}