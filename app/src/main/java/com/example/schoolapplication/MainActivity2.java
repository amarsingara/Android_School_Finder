package com.example.schoolapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.common.util.CollectionUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity{
    private final static String JSON_FILE = "secondary_reformatted.json";
    private SecondaryAdapter secondaryAdapter;
    public BaseSecondary list;
    private ListView listView;
    private ArrayList<Schools> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        data = (ArrayList<Schools>) args.getSerializable("ARRAYLIST");
        List<Secondary> secondaryList = list.getSecondary();

        for(int k = 0; k < data.size(); k ++){
            for(int j = 0; j < secondaryList.size(); j++) {
                if (data.get(k).getPlaceType().contains(secondaryList.get(j).getSchoolName())){
                    secondaryList.get(j).setDistance(data.get(k).getDist_to());
                    secondaryList.get(j).setLon(data.get(k).getLon());
                    secondaryList.get(j).setLat(data.get(k).getLat());
                    System.out.println(secondaryList.get(k).getDistance());
                }
            }

        }

        ListView listView = findViewById(R.id.listView);
        System.out.print(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {
                Intent i = new Intent(MainActivity2.this, SecondaryDetails.class);
                i.putExtra("index", (int)id);
                i.putExtra("LIST", (Serializable) secondaryList);
                startActivity(i);

            }
        });
    }
    public void init() {
        listView = findViewById(R.id.listView);
        secondaryAdapter = new SecondaryAdapter(MainActivity2.this, getSecondaryData());
        listView.setAdapter(secondaryAdapter);
    }

    /* Convert JSON String to BaseStudent Model via GSON */
    public List<Secondary> getSecondaryData() {
        String jsonString = getAssetsJSON(JSON_FILE);
        Log.d("MainActivity", "Json: " + jsonString);
        Gson gson = new Gson();
        BaseSecondary baseSecondary = gson.fromJson(jsonString, BaseSecondary.class);
        baseSecondary.sortSecondary();
        list = baseSecondary;
        return  baseSecondary.getSecondary();
    }

    /* Get File in Assets Folder */
    public String getAssetsJSON(String fileName) {
        String json = null;
        try {
            InputStream inputStream = this.getAssets().open(fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }
}
