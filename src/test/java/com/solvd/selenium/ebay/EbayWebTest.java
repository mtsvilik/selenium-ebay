package com.solvd.selenium.ebay;

import com.solvd.selenium.ebay.page.*;
import com.solvd.selenium.ebay.utils.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EbayWebTest extends AbstractTest {

    @Test
    public void verifyHomePageIsOpenTest() {
        HomePage homePage = new HomePage(getDriver());

        Assert.assertEquals("https://www.ebay.com/", PropertyReader.getProperty("url"),
                "Home page should contains url");
    }
}
