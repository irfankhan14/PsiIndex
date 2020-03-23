package com.irfan.singapore.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ikhans
 */
public class PsiResponse {

    @SerializedName("region_metadata")
    @Expose
    private List<RegionMetadatum> regionMetadata = null;

    @SerializedName("items")
    @Expose
    private List<Item> items = null;

    public List<RegionMetadatum> getRegionMetadata() {
        return regionMetadata;
    }

    public List<Item> getItems() {
        return items;
    }

}
