package com.example.schoolapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SecondaryAdapter extends BaseAdapter {
    private Context context;
    private List<Secondary> dataList;
    private TextView tvRank;
    private TextView tvSchoolName;
    private TextView someDistance;
//    private TextView tvSchool;
    private View vi;
    private static LayoutInflater inflater = null;


    public SecondaryAdapter(Context context, List<Secondary> dataList){
        this.context = context;
        this.dataList = dataList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() { return dataList.size(); }

    @Override
    public Object getItem(int i) { return i; }

    @Override
    public long getItemId(int i) { return i; }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        //Populate the Listview
        final int pos = position;
        Secondary secondary = dataList.get(pos);

        vi = inflater.inflate(R.layout.list_item_secondary, viewGroup, false);
        tvRank = vi.findViewById(R.id.tvRank);
        tvSchoolName = vi.findViewById(R.id.tvSchoolName);
        someDistance = vi.findViewById(R.id.tvDist);

        String full = String.format("%s", secondary.getSchoolName());

        someDistance.setText(String.valueOf(secondary.getDistance()/1000) + "km");
        tvRank.setText(String.valueOf(secondary.getRank()));
        tvSchoolName.setText(full);



        return vi;
    }
    public List<Secondary> getdataList(){return dataList;}
}
