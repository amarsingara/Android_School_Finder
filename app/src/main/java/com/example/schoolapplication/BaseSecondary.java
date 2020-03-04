package com.example.schoolapplication;

import android.content.Intent;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;


public class BaseSecondary {
    @SerializedName("secondary")
    @Expose
    private List<Secondary> secondary = new ArrayList<>();
    private static final String KEY_NAME = "Rank";

    public void sortSecondary() {
        Collections.sort(this.secondary, (a, b) -> a.getRank() - b.getRank());

//        Collections.sort(this.secondary, new Comparator<Secondary> (){
//            public int compare(Secondary o1, Secondary o2) {
//                return o1.getRank() - o2.getRank();
//            }
//        });
    }


    public List<Secondary> getSecondary() {
        return secondary;
    }



}
