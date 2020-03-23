
package com.irfan.singapore.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LabelLocation {

    @SerializedName("latitude")
    @Expose
    private Float latitude;

    @SerializedName("longitude")
    @Expose
    private Float longitude;

    public Float getLatitude() {
        return latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

}
