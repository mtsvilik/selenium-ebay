package com.solvd.selenium.ebay;

import com.solvd.selenium.ebay.page.*;
import com.solvd.selenium.ebay.utils.TestDataReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EbayWebTest extends AbstractTest {

    @Test
    public void verifyShoppingCartIconIsClickableTest() {
        HomePage homePage = new HomePage(getDriver());
        ShoppingCartPage shoppingCartPage = homePage.clickShoppingCartIcon();

        Assert.assertEquals(shoppingCartPage.getEmptyCartText(), TestDataReader.getTestData("text"),
                "Shopping cart page should contains cart is empty text");
    }
}
