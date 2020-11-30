package com.example.mymapapp;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private LatLng periyakalapet = new LatLng(12.0313, 79.8642);
    private LatLng kaspontechwork = new LatLng(12.9718922,80.2467993);
    private LatLng oldMahapalipuram = new LatLng(12.912613,80.2269593);

    private Marker kalapetMarker;
    private Marker kasponMarker;
    private Marker mahapalipuramMarker;

    private MarkerOptions kalapetMarkerOptions;
    private MarkerOptions kasponMarkerOptions;
    private MarkerOptions mahapalipuramMarkerOptions;

    private ArrayList<Marker> markerArrayList;
    private List<MarkerOptions> markerOptionsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        markerArrayList = new ArrayList<>();
        markerOptionsList = new ArrayList<>();

        kalapetMarkerOptions = new MarkerOptions().position(periyakalapet).title("Marker in periyakalapet")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                .alpha(0.6f);
        markerOptionsList.add(kalapetMarkerOptions);

        kasponMarkerOptions = new MarkerOptions().position(kaspontechwork).title("Marker in kaspontechwork")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                .alpha(0.8f);
        markerOptionsList.add(kasponMarkerOptions);

        mahapalipuramMarkerOptions = new MarkerOptions().position(oldMahapalipuram).title("Marker in oldMahapalipuram")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW))
                .alpha(0.6f);
        markerOptionsList.add(mahapalipuramMarkerOptions);

        for (MarkerOptions markerOptions: markerOptionsList){
            LatLng latLng = new LatLng(markerOptions.getPosition().latitude, markerOptions.getPosition().longitude);
            mMap.addMarker(markerOptions);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12));
            //Log.d("map", "onMapReady: " + marker.getTitle());
        }


/*
        kalapetMarker = mMap.addMarker(kalapetMarkerOptions);
        markerArrayList.add(kalapetMarker);

        kasponMarker = mMap.addMarker(kasponMarkerOptions);
        markerArrayList.add(kasponMarker);

        mahapalipuramMarker = mMap.addMarker(mahapalipuramMarkerOptions);
        markerArrayList.add(mahapalipuramMarker);

        for (Marker marker: markerArrayList){
            LatLng latLng = new LatLng(marker.getPosition().latitude, marker.getPosition().longitude);
            mMap.addMarker(new MarkerOptions().position(latLng));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12));
            //Log.d("map", "onMapReady: " + marker.getTitle());
        } */




        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        //LatLng periyakalapet = new LatLng(12.0313, 79.8642);

        //mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        //mMap.addMarker(new MarkerOptions().position(periyakalapet).title("Marker in periyakalapet"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(periyakalapet));
       /* mMap.addMarker(new MarkerOptions().position(periyakalapet).title("Marker in periyakalapet")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                .alpha(0.6f));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(periyakalapet, 14));
        mMap.addMarker(new MarkerOptions().position(periyakalapet).title("Marker in periyakalapet")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                .alpha(0.6f));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(periyakalapet, 14));

        */
    }
}