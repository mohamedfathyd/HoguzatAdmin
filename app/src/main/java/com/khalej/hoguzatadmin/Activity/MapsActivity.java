package com.khalej.hoguzatadmin.Activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.Handler;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.khalej.hoguzatadmin.R;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;


public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

private GoogleMap mMap;
String lati,longg;
Intent intent;
Handler mHandler;
    String detail;
    float lat;
    float lng;
    private SharedPreferences sharedpref;
    private SharedPreferences.Editor edt;
    int getCategory_id,gender_id;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_maps);

    // Obtain the SupportMapFragment and get notified when the map is ready to be used.
    SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
            .findFragmentById(R.id.map);
    mapFragment.getMapAsync(this);
    intent=getIntent();
    getCategory_id=intent.getIntExtra("id",0);
    gender_id=intent.getIntExtra("category",0);

}


/**
 * Manipulates the map once available.
 * This callback is triggered when the map is ready to be used.
 * This is where we can add markers or lines, add listeners or move the camera. In this case,
 * we just add a marker near Sydney, Australia.
 * If Google Play services is not installed on the device, the user will be prompted to install
 * it inside the SupportMapFragment. This method will only be triggered once the user has
 * installed Google Play services and returned to the app.
 */
@Override
public void onMapReady(GoogleMap googleMap) {
    mMap = googleMap;

    // Add a marker in Sydney and move the camera
    LatLng sydney = new LatLng(25.7225227, 51.3740656);
    // mMap.addMarker(new MarkerOptions().position(sydney).title("HandMade"));
    // mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    CameraUpdate location= CameraUpdateFactory.newLatLngZoom(sydney,6);
    mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
        @Override
        public void onMapClick(LatLng latLng) {
            mMap.addMarker(new MarkerOptions().position(latLng).title("Hoguzat"));
            mylocation(latLng);
        }
    });
    mMap.animateCamera(location);

}

@Override
public void onPointerCaptureChanged(boolean hasCapture) {

}
    public void mylocation(final LatLng latLng){

        new AlertDialog.Builder(MapsActivity.this)
                .setTitle("Hoguzat App")
                .setMessage("هل هذا هو موقع المنتج ؟")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        Geocoder geocoder;
                        List<Address> addresses = null;
                        geocoder = new Geocoder(MapsActivity.this, Locale.getDefault());

                        try {
                            addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                       Intent intent=new Intent(MapsActivity.this,CardView.class);
                        intent.putExtra("lat",latLng.latitude);
                        intent.putExtra("lng",latLng.longitude);
                        intent.putExtra("id",getCategory_id);
                        intent.putExtra("category",gender_id);
                        startActivity(intent);
                        finish();


                    }})
                .setNegativeButton(android.R.string.no,  new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        mMap.clear();
                    }}).show();

    }
}

