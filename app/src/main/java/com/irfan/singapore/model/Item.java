
package com.irfan.singapore.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("timestamp")
    @Expose
    private String timestamp;

    @SerializedName("update_timestamp")
    @Expose
    private String updateTimestamp;

    @SerializedName("readings")
    @Expose
    private Readings readings;

    public Readings getReadings() {
        return readings;
    }


}
