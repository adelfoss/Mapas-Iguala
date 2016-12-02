package com.example.adelfo.mismapas;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class MainActivity extends AppCompatActivity {

    private String marcador;
    private Float colorMarcador;
    private double latitud;
    private double longitud;
    private int zoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new AdaptadorImagen(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                switch (position) {
                    case 0:
                        marcador = getApplicationContext().getResources().getString(R.string.ubicacion1);
                        colorMarcador = BitmapDescriptorFactory.HUE_AZURE;
                        latitud = 18.32922885591849;
                        longitud = -99.53276063300746;
                        zoom = 14;
                        break;
                    case 1:
                        marcador = getApplicationContext().getResources().getString(R.string.ubicacion2);
                        colorMarcador = BitmapDescriptorFactory.HUE_ORANGE;
                        latitud = 18.341297;
                        longitud = -99.521404;
                        zoom = 17;
                        break;
                    case 2:
                        marcador = getApplicationContext().getResources().getString(R.string.ubicacion3);
                        colorMarcador = BitmapDescriptorFactory.HUE_GREEN;
                        latitud = 18.344810626547126;
                        longitud = -99.53923819075315;
                        zoom = 19;
                        break;
                    case 3:
                        marcador = getApplicationContext().getResources().getString(R.string.ubicacion4);
                        colorMarcador = BitmapDescriptorFactory.HUE_BLUE;
                        latitud = 18.345024481857337;
                        longitud = -99.54115060578077;
                        zoom = 17;
                        break;
                }

                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                intent.putExtra(getApplicationContext().getResources().getString(R.string.numeroUbicacion), ""+(position+1));
                intent.putExtra(getApplicationContext().getResources().getString(R.string.marcador), ""+marcador);
                intent.putExtra(getApplicationContext().getResources().getString(R.string.latitud), ""+latitud);
                intent.putExtra(getApplicationContext().getResources().getString(R.string.longitud), ""+longitud);
                intent.putExtra(getApplicationContext().getResources().getString(R.string.zoom), ""+zoom);
                intent.putExtra(getApplicationContext().getResources().getString(R.string.colorMarcador), ""+colorMarcador);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mAcercaDe){
            Intent intent = new Intent(this, AcercaDeActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
