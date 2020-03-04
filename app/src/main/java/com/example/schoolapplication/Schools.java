package com.example.schoolapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Schools implements Serializable {

    @SerializedName("PLACETYPE")
    @Expose
    private String placeType;

    public String getPlaceType() {
        return placeType;
    }

    public void setPlaceType(String name) {
        placeType = name;
    }

    @SerializedName("lat")
    @Expose
    private double lat;

    public double getLat() {
        return lat;
    }

    public void setLat(double name) {
        lat = name;
    }

    @SerializedName("lon")
    @Expose
    private double lon;

    public double getLon() {
        return lon;
    }

    public void setLon(double name) {
        lon = name;
    }

    @SerializedName("dist_to")
    @Expose
    private float dist_to;

    public float getDist_to() {
        return dist_to;
    }

    public void setDist_to(float name) {
        dist_to = name;
    }
}

