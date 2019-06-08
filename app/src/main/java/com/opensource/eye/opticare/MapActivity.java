package com.opensource.eye.opticare;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Services.HttpRequest;

public class MapActivity extends FragmentActivity implements GoogleMap.OnInfoWindowClickListener, OnMapReadyCallback  {

    private GoogleMap mMap;

    RequestQueue queue = null;
    String url =new HttpRequest().getUri();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        queue = Volley.newRequestQueue(this);
        getLocations();
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

//        final LatLng MELBOURNE = new LatLng(-37.81319, 144.96298);
//
//        Marker melbourne = mMap.addMarker(new MarkerOptions()
//                .position(MELBOURNE)
//                .title("Melbourne"));
//        melbourne.showInfoWindow();
//
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(MELBOURNE));


        mMap.setOnInfoWindowClickListener(this);
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Toast.makeText(this, "Info window clicked"+marker.getPosition(),
                Toast.LENGTH_SHORT).show();
    }


    public void getLocations(){
            JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url+"/user/1/optician/locations", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response)
            {
                if(response.length()>0){

                    Toast.makeText(getApplicationContext(),"Loading......",Toast.LENGTH_LONG).show();


                    try {

                    JSONArray jsonArray = response.getJSONArray("opticians");
                        System.out.println(jsonArray.toString());
                        for (int x = 0; x < jsonArray.length(); x++)
                        {
                            Toast.makeText(getApplicationContext(),"test value "+String.valueOf(x),Toast.LENGTH_LONG).show();

                            double lat = jsonArray.getJSONObject(x).getDouble("latitude");
                            double lng = jsonArray.getJSONObject(x).getDouble("longitude");
                            String title = jsonArray.getJSONObject(x).getString("shop_name");

                            LatLng Position = new LatLng(lat, lng);

                            Marker marker = mMap.addMarker(new MarkerOptions()
                                                .position(Position)
                                                .title(title));
                            marker.showInfoWindow();

                            if(x == 0 ){
                                mMap.moveCamera(CameraUpdateFactory.newLatLng(Position));
                            }

                        }

                    }
                    catch (JSONException e){
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                    }

                }else{
                    Toast.makeText(getApplicationContext(),"No opticians to suggest....",Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("error : "+error.getMessage()+" url "+url+"post");
                Toast.makeText(getApplicationContext(),"error : "+error.getMessage()+" url "+url+"post",Toast.LENGTH_LONG).show();
            }
        });
        queue.add(objectRequest);
    }


}
