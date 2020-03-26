package com.example.schoolapplication;

import android.annotation.SuppressLint;
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
import java.util.regex.Pattern;


public class SecondaryDetails extends AppCompatActivity implements View.OnClickListener{

    private int index;
    private List<Secondary> list;

    @SuppressLint("SetTextI18n")
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

//        TextView gr12 = findViewById(R.id.gr12);
//        gr12.setText(Integer.toString(list.get(index).getGr12()));
        TextView esl = findViewById(R.id.esl);
        esl.setText(Float.toString(list.get(index).getesl()));

        TextView sneeds = findViewById(R.id.specialneeds);
        sneeds.setText(Float.toString(list.get(index).getsneeds()));

        TextView french = findViewById(R.id.french);
        french.setText(Float.toString(list.get(index).getfrench()));

        TextView year0 = findViewById(R.id.year0);
        String seperateYear = list.get(index).getyear();
        String[] seperateData = seperateYear.split(Pattern.quote(","));
        year0.setText(seperateData[4]);

        TextView aver_mark = findViewById(R.id.avg_mark);
        String seperateacd = list.get(index).getaver_mark();
        String[] seperateData2 = seperateacd.split(Pattern.quote(","));
        aver_mark.setText(seperateData2[4]);

        TextView fail = findViewById(R.id.fail);
        String fail1 = list.get(index).getfail();
        String[] seperateData3 = fail1.split(Pattern.quote(","));
        fail.setText(seperateData3[4]);

        TextView diff = findViewById(R.id.diff);
        String dd = list.get(index).getDiff();
        String[] seperateData4 = dd.split(Pattern.quote(","));
        diff.setText(seperateData4[4]);

        TextView grate = findViewById(R.id.grate);
        String sss = list.get(index).getgrate();
        String[] seperateData5 = sss.split(Pattern.quote(","));
        grate.setText(seperateData5[4]);

        TextView arate = findViewById(R.id.arate);
        String ok = list.get(index).getarate();
        String[] seperateData6 = ok.split(Pattern.quote(","));
        arate.setText(seperateData6[4]);

        TextView rating = findViewById(R.id.rating);
        String yea = list.get(index).getrating();
        String[] seperateData7 = yea.split(Pattern.quote(","));
        rating.setText(seperateData7[4]);




        Button b =findViewById(R.id.button2);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(SecondaryDetails.this, MapView.class);
        i.putExtra("lat", list.get(index).getLat());
        i.putExtra("lon", list.get(index).getLon());
        i.putExtra("name" , list.get(index).getSchoolName());


        startActivity(i);
    }


}
