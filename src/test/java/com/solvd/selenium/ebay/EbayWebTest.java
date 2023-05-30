package com.solvd.selenium.ebay;

import com.solvd.selenium.ebay.page.*;
import com.solvd.selenium.ebay.utils.PropertyReader;
import com.solvd.selenium.ebay.utils.TestDataReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class EbayWebTest extends AbstractTest {

    @Test
    public void verifyHomePageIsOpenTest() {
        HomePage homePage = new HomePage(getDriver());

        Assert.assertEquals("https://www.ebay.com/", PropertyReader.getProperty("url"),
                "Home page should contains url");
    }

    @Test
    public void verifyAllCategoriesSelectIsWorkingTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.checkSelect();
        Assert.assertEquals(homePage.getSelectTitle(), TestDataReader.getTestData("selectTitle"),
                "All Categories select isn't worked");
    }

    @Test
    public void verifySearchResultsTest() {
        HomePage homePage = new HomePage(getDriver());
        SearchResultPage searchResultPage = homePage.openResultPage(TestDataReader.getTestData("searchText"));
        List<String> titles = searchResultPage.showResults();
        SoftAssert softAssert = new SoftAssert();
        titles.forEach(title ->
                softAssert.assertTrue(title.contains(TestDataReader.getTestData("searchText"))));
        softAssert.assertAll();
        ProductPage productPage = searchResultPage.chooseRandomProduct();
        productPage.showShippingInfo();
        softAssert.assertTrue(productPage.getShippingButton(),
                "Shipping button isn't checked");
    }
}
