package com.example.schoolapplication;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;


public class SecondaryDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_secondary);
        Intent intent = this.getIntent();
        int index = (Integer) getIntent().getExtras().get("index");
        List<Secondary> list = (List<Secondary>) intent.getSerializableExtra("LIST");
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

    }
}
