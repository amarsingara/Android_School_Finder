package com.example.schoolapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Secondary implements Serializable {
    @SerializedName("Rank")
    @Expose
    private int rank;
    public int getRank() {
        return rank;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }

    @SerializedName("school_name")
    @Expose
    private String schoolName;
    public String getSchoolName() {
        return schoolName;
    }
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @SerializedName("Gr_Enrollment")
    @Expose
    private int enrollment;
    public int getEnrollment(){return enrollment;}
    public void setEnrollment(int enrollment) {this.enrollment = enrollment;}

    @SerializedName("distance")
    @Expose
    private float distance;
    public float getDistance(){return distance;}
    public void setDistance(float enrollment) {this.distance = enrollment;}

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

//    @SerializedName("Gr_Enrollment")
//    @Expose
//    private int gr12;
//    public void setgr12(int some){gr12=some;}
//    public int getGr12(){
//        return gr12;
//    }

    @SerializedName("ESL")
    @Expose
    private float esl;
    public void setesl(float some){esl=some;}
    public float getesl(){
        return esl;
    }

    @SerializedName("Special_needs")
    @Expose
    private float sneeds;
    public void setsneeds(float some){sneeds=some;}
    public float getsneeds(){
        return sneeds;
    }

    @SerializedName("French Imm (%)")
    @Expose
    private float french;
    public void setfrench(float some){french=some;}
    public float getfrench(){
        return french;
    }

    @SerializedName("Academic Performance")
    @Expose
    private String year;
    public void setyear(String some){year=some;}
    public String getyear(){
        return year;
    }

    @SerializedName("Average exam mark")
    @Expose
    private String aver_mark;
    public void setaver_mark(String some){aver_mark=some;}
    public String getaver_mark(){
        return aver_mark;
    }

    @SerializedName("Percentage of exams failed")
    @Expose
    private String fail;
    public void setfail(String some){fail=some;}
    public String getfail(){
        return fail;
    }

    @SerializedName("School vs exam mark difference")
    @Expose
    private String diff;
    public void setdiff(String some){diff=some;}
    public String getDiff(){
        return diff;
    }

    @SerializedName("Graduation rate")
    @Expose
    private String grate;
    public void setgrate(String some){grate=some;}
    public String getgrate(){
        return grate;
    }

    @SerializedName("Delayed advancement rate")
    @Expose
    private String arate;
    public void setarate(String some){arate=some;}
    public String getarate(){
        return arate;
    }

    @SerializedName("Overall rating out of 10")
    @Expose
    private String rating;
    public void setrating(String some){rating=some;}
    public String getrating(){
        return rating;
    }




//    "BCRank": 167,
//            "Rank": 7,
//            "school_name":"Alpha [Public] Burnaby",
//            "Gr 12 Enrollment": 241,
//            "ESL (%)": "2.5",
//            "Special needs (%)": 11.0,
//            "French Imm (%)": 13.6,
//            "Actual rating vs predicted based 2017-18 Last 5 Years on parents\u2019 avg. inc. of $ n\/a: n\/a": "Rank:  167\/251 188\/240",
//            "Academic Performance": "2014 2015 2016 2017 2018",
//            "Average exam mark":"69.0 68.3 67.6 65.1 68.7",
//            "Percentage of exams failed": "9.8 11.5 11.7 16.2 10.0",
//            "School vs exam mark difference": "7.6 6.4 8.8 11.1 7.7",
//            "English gender gap":"F 4.2 F 6.7 F 4.3 F 6.8 F 5.4 ",
//            "Math gender gap":"M 4.4 F 1.1 F 0.4 n\/a n\/a n\/a",
//            "Graduation rate":"92.4 94.8 91.4 87.7 95.6",
//            "Delayed advancement rate":"24.3 15.0 13.6 17.7 10.2",
//            "Overall rating out of 10": "5.0 5.5 5.3 3.6 5.4 "
}
