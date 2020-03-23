package com.irfan.singapore.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ikhans
 */
public class ReadingDetails {

    @SerializedName("west")
    @Expose
    private String west;

    @SerializedName("national")
    @Expose
    private String national;

    @SerializedName("east")
    @Expose
    private String east;

    @SerializedName("central")
    @Expose
    private String central;

    @SerializedName("south")
    @Expose
    private String south;

    @SerializedName("north")
    @Expose
    private String north;

    public String getWest() {
        return west;
    }

    public String getEast() {
        return east;
    }

    public String getCentral() {
        return central;
    }

    public String getSouth() {
        return south;
    }

    public String getNorth() {
        return north;
    }
}
