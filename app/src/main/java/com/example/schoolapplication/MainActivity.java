package com.example.schoolapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    public EditText etPlace;
    public Button btSubmit;
    private String FEED_URL;
    private ArrayList<Schools> mListData = new ArrayList<Schools>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPlace = findViewById(R.id.editText);
        btSubmit = findViewById(R.id.button);
        FEED_URL = "https://opendata.arcgis.com/datasets/4e99b5545f59441ea9a0cfcfaf656e1a_1.geojson";

        new MainActivity.AsyncHttpTask().execute(FEED_URL);

    }

    //Downloading data asynchronously
    public class AsyncHttpTask extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... urls) {
        String result = "";
        URL url;
        HttpsURLConnection urlConnection = null;

        try {
            url = new URL(urls[0]);

            urlConnection = (HttpsURLConnection) url.openConnection();


            if (result != null) {

                String response = streamToString(urlConnection.getInputStream());


                parseResult(response);



                return result;



            }
        } catch (MalformedURLException e) {
            e.printStackTrace();


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
    }

    String streamToString(InputStream stream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
        String line;
        String result = "";
        while ((line = bufferedReader.readLine()) != null) {
            result += line;
        }

        // Close stream
        if (null != stream) {
            stream.close();
        }
        return result;
    }

    private void parseResult(String result) {
        try {
            JSONObject response = new JSONObject(result);
            JSONArray posts = response.optJSONArray("features");
            Schools item;
            for (int i = 0; i < posts.length(); i++) {
                JSONObject post = posts.optJSONObject(i);
                String properties = post.optString("properties");
                String geometry = post.optString("geometry");
                JSONObject jsonObject = new JSONObject(properties);
                JSONObject jsonObject1 = new JSONObject(geometry);
                String desc = jsonObject.optString("DESCRIPTION");
                JSONArray coordinates = jsonObject1.getJSONArray("coordinates");
                double latitude = coordinates.getDouble(1);
                double longitude = coordinates.getDouble(0);

                if (desc.contains("SECONDARY") || desc.contains("Carver Christian High School") || desc.contains("St Thomas More Collegiate")) {
                    item = new Schools();
                    mListData.add(item);
                    item.setPlaceType(desc);
                    item.setLat(latitude);
                    item.setLon(longitude);

                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney, Australia, and move the camera.
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));



    }


    public void decode(View view) throws IOException {

        String location = etPlace.getText().toString();
        Geocoder gc = new Geocoder(this);
        List<Address> list = gc.getFromLocationName(location, 1);
        Address add = list.get(0);
        String locality = add.getLocality();
        double lat = add.getLatitude();
        double lon = add.getLongitude();

        float[] result = new float[11];
       // ArrayList<Float> x = new ArrayList<>();

        for(int k = 0; k < 10; k++){
            Location.distanceBetween(lat, lon, mListData.get(k).getLat() , mListData.get(k).getLon(), result);
            for(int j = 0; j < 11; j +=11){
               // x.add(result[j]);
                mListData.get(k).setDist_to(result[j]);
            }

        }
//        Toast.makeText(this, "" + mListData.get(0).getDist_to()+ "km", Toast.LENGTH_LONG).show();

        Intent i = new Intent(MainActivity.this, MainActivity2.class);
        Bundle args = new Bundle();
        args.putSerializable("ARRAYLIST",(Serializable)mListData);
        i.putExtra("BUNDLE",args);
        startActivity(i);


    }
}
