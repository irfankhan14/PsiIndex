package com.irfan.singapore.model;

import com.google.gson.annotations.Expose;

/**
 * Created by ikhans
 */
public class ReadingDetailsPair {
    @Expose
    private String title;

    @Expose
    private String value;

    public ReadingDetailsPair(String title, String value) {
        this.title = title;
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public String getValue() {
        return value;
    }


}
