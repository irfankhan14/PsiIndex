package com.irfan.singapore;

import com.irfan.singapore.utils.ReadingListDetails;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ikhans
 */
public final class ReadingsDetailsTest {

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

}

