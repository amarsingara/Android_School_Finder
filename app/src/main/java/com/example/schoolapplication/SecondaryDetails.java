package com.example.schoolapplication;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.Serializable;
import java.util.List;


public class SecondaryDetails extends AppCompatActivity implements View.OnClickListener{

    private int index;
    private List<Secondary> list;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_secondary);
        Intent intent = this.getIntent();
        index = (Integer) getIntent().getExtras().get("index");
        list = (List<Secondary>) intent.getSerializableExtra("LIST");
        System.out.print(index);
//        Bundle bundle = intent.getExtras();

//        BaseSecondary baseSecondary = (BaseSecondary) bundle.getSerializable("SECONDARYADAPTER");
//        List<Secondary> secondary = baseSecondary.getSecondary();

        TextView rank = findViewById(R.id.rank);
//        rank.setText(list.get(index).getRank());
        rank.setText(Integer.toString(list.get(index).getRank()));

        TextView schoolName = findViewById(R.id.schoolName);
        schoolName.setText(list.get(index).getSchoolName());

        TextView enrollment = findViewById(R.id.enrollment);
//        enrollment.setText(list.get(index).getEnrollment());
        enrollment.setText(Integer.toString(list.get(index).getEnrollment()));

        Button b =findViewById(R.id.button2);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(SecondaryDetails.this, MapView.class);
        i.putExtra("lat", list.get(index).getLat());
        i.putExtra("lon", list.get(index).getLon());


        startActivity(i);
    }

}
