package com.irfan.singapore;

import com.irfan.singapore.utils.ReadingListDetails;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public final void getRegionTitleSuccess() {
        String text = "Click to see Psi Index details for : north";
        Assert.assertEquals("north", ReadingListDetails.getRegionTitle(text));
    }

    @Test
    public final void getRegionTitleIncorrectText() {
        String text = "Click to see Psi Index details for north";
        Assert.assertEquals("north", ReadingListDetails.getRegionTitle(text));
    }

    @Test
    public final void getRegionTitleForNull() {
        String text = null;
        Assert.assertNotEquals("south", ReadingListDetails.getRegionTitle(text));
    }
}