package com.irfan.singapore.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ikhans
 */
public class Readings {
    @SerializedName("o3_sub_index")
    @Expose
    private ReadingDetails o3_sub_index;

    @SerializedName("pm10_twenty_four_hourly")
    @Expose
    private ReadingDetails pm10_twenty_four_hourly;

    @SerializedName("pm10_sub_index")
    @Expose
    private ReadingDetails pm10_sub_index;

    @SerializedName("co_sub_index")
    @Expose
    private ReadingDetails co_sub_index;

    @SerializedName("pm25_twenty_four_hourly")
    @Expose
    private ReadingDetails pm25_twenty_four_hourly;

    @SerializedName("so2_sub_index")
    @Expose
    private ReadingDetails so2_sub_index;

    @SerializedName("co_eight_hour_max")
    @Expose
    private ReadingDetails co_eight_hour_max;

    @SerializedName("no2_one_hour_max")
    @Expose
    private ReadingDetails no2_one_hour_max;

    @SerializedName("so2_twenty_four_hourly")
    @Expose
    private ReadingDetails so2_twenty_four_hourly;

    @SerializedName("pm25_sub_index")
    @Expose
    private ReadingDetails pm25_sub_index;

    @SerializedName("psi_twenty_four_hourly")
    @Expose
    private ReadingDetails psi_twenty_four_hourly;

    @SerializedName("o3_eight_hour_max")
    @Expose
    private ReadingDetails o3_eight_hour_max;

    public ReadingDetails getO3_sub_index() {
        return o3_sub_index;
    }

    public ReadingDetails getPm10_twenty_four_hourly() {
        return pm10_twenty_four_hourly;
    }

    public ReadingDetails getPm10_sub_index() {
        return pm10_sub_index;
    }

    public ReadingDetails getCo_sub_index() {
        return co_sub_index;
    }

    public ReadingDetails getPm25_twenty_four_hourly() {
        return pm25_twenty_four_hourly;
    }

    public ReadingDetails getSo2_sub_index() {
        return so2_sub_index;
    }

    public ReadingDetails getCo_eight_hour_max() {
        return co_eight_hour_max;
    }

    public ReadingDetails getNo2_one_hour_max() {
        return no2_one_hour_max;
    }

    public ReadingDetails getSo2_twenty_four_hourly() {
        return so2_twenty_four_hourly;
    }

    public ReadingDetails getPm25_sub_index() {
        return pm25_sub_index;
    }

    public ReadingDetails getPsi_twenty_four_hourly() {
        return psi_twenty_four_hourly;
    }

    public ReadingDetails getO3_eight_hour_max() {
        return o3_eight_hour_max;
    }
}
