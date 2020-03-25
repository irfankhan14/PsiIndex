package com.irfan.singapore;

import com.google.gson.Gson;
import com.irfan.singapore.model.PsiResponse;
import com.irfan.singapore.utils.ReadingListDetails;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ikhans
 */
public final class ReadingsDetailsTest {

    private String validJson = "{\"region_metadata\":[{\"name\":\"south\",\"label_location\":{\"latitude\":1.29587,\"longitude\":103.82}},{\"name\":\"north\",\"label_location\":{\"latitude\":1.41803,\"longitude\":103.82}}],\"items\":[{\"timestamp\":\"2020-03-25T18:00:00+08:00\",\"update_timestamp\":\"2020-03-25T18:08:52+08:00\",\"readings\":{\"o3_sub_index\":{\"west\":13,\"national\":17,\"east\":12,\"central\":17,\"south\":17,\"north\":16}, \"o3_eight_hour_max\":{\"west\":31,\"national\":41,\"east\":28,\"central\":40,\"south\":41,\"north\":38}}}],\"api_info\":{\"status\":\"healthy\"}}";
    private String inValidJson = null;

    @Test
    public final void getRegionTitleSuccess() {
        String text = "Click to see Psi Index details for : north";
        Assert.assertEquals("north", ReadingListDetails.getRegionTitle(text));
    }

    @Test
    public final void getRegionTitleIncorrectText() {
        String text = "Click to see Psi Index details for : north";
        Assert.assertNotEquals("south", ReadingListDetails.getRegionTitle(text));
    }

    @Test
    public final void getRegionTitleForNull() {
        String text = null;
        Assert.assertNull(text);
    }

    @Test
    public final void checkSuccessResponse() {
        Gson gson = new Gson();
        PsiResponse psiResponse = gson.fromJson(validJson, PsiResponse.class);
        Assert.assertEquals("north", psiResponse.getRegionMetadata().get(1).getName());
        Assert.assertEquals("south", psiResponse.getRegionMetadata().get(0).getName());
        Assert.assertNotEquals(null, psiResponse.getItems().get(0).getReadings());
    }

    @Test
    public final void checkFailureResponse() {
        Gson gson = new Gson();
        PsiResponse psiResponse = gson.fromJson(validJson, PsiResponse.class);
        Assert.assertNotEquals(0, psiResponse.getItems().size());
        Assert.assertNotEquals("east", psiResponse.getRegionMetadata().get(0).getName());
    }

    @Test
    public final void checkNullResponse() {
        Gson gson = new Gson();
        PsiResponse psiResponse = gson.fromJson(inValidJson, PsiResponse.class);
        Assert.assertNull(psiResponse);
    }
}

