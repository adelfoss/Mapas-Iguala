package com.example.adelfo.mismapas;

import android.content.Intent;
import android.support.annotation.FloatRange;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {//FragmentActivity,

    private GoogleMap mMap;
    private String numeroUbicacion, sMarcador, colorMarcador, sLatitud, sLongitud, sZoom;
    private float colorMarcador2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        numeroUbicacion = intent.getStringExtra(getApplicationContext().getResources().getString(R.string.numeroUbicacion));
        sMarcador = intent.getStringExtra(getApplicationContext().getResources().getString(R.string.marcador));
        sLatitud = intent.getStringExtra(getApplicationContext().getResources().getString(R.string.latitud));
        sLongitud = intent.getStringExtra(getApplicationContext().getResources().getString(R.string.longitud));
        sZoom = intent.getStringExtra(getApplicationContext().getResources().getString(R.string.zoom));
        colorMarcador = intent.getStringExtra(getApplicationContext().getResources().getString(R.string.colorMarcador));

        colorMarcador2 = Float.parseFloat(colorMarcador);
        setTitle(sMarcador);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng ubicacion = new LatLng(Double.parseDouble(sLatitud), Double.parseDouble(sLongitud));
        mMap.addMarker(new MarkerOptions()
                .position(ubicacion)
                .icon(BitmapDescriptorFactory.defaultMarker(colorMarcador2))
                .alpha(0.7f)
                .title(sMarcador)
                .snippet("Ubicación "+numeroUbicacion)
        );


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacion, Integer.parseInt(sZoom)));
    }
}
