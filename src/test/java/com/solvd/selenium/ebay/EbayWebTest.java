package com.solvd.selenium.ebay;

import com.solvd.selenium.ebay.page.*;
import com.solvd.selenium.ebay.utils.TestDataReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EbayWebTest extends AbstractTest {

    @Test
    public void verifyShoppingCartIconIsClickable() {
        HomePage homePage = new HomePage(driver);
        ShoppingCartPage shoppingCartPage = homePage.clickShoppingCartIcon();
        Assert.assertEquals(shoppingCartPage.getEmptyCartText(), TestDataReader.getTestData("text"),
                "Shopping cart page should contains cart is empty text");
    }

    @Test
    public void checkSignInWithValidData() {
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = homePage.clickSignInButton();
        signInPage.enterEmail(TestDataReader.getTestData("email"));
        AccountPage accountPage = signInPage.enterPassword(TestDataReader.getTestData("password"));
        Assert.assertTrue(accountPage.getContinueButton(),
                "Account page should contains sign in text");
    }

    @Test
    public void verifyElectronicsMainContentIsWorking() {
        HomePage homePage = new HomePage(driver);
        CategoryPage categoryPage = homePage.chooseComputerCategory();
        Assert.assertEquals(categoryPage.getPageTitle(), TestDataReader.getTestData("pageTitle"),
                "Category page should contains page title text");
    }

    @Test
    public void verifyMoreFiltersButtonIsClickable() {
        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = homePage.openResultPage(TestDataReader.getTestData("searchText"));
        searchResultPage.clickMoreFiltersButton();
        Assert.assertTrue(searchResultPage.getFilterElement(), "Filter element isn't present");
    }

    @Test
    public void verifyRegistrationWithEmptyRequiredFields() {
        HomePage homePage = new HomePage(driver);
        SignUpPage signUpPage = homePage.clickRegisterButton();
        Assert.assertFalse(signUpPage.clickCreateAccount(), "Create account button isn't clickable");
    }

    @Test
    public void verifyBusinessAccountRadioButtonIsChecked() {
        HomePage homePage = new HomePage(driver);
        SignUpPage signUpPage = homePage.clickRegisterButton();
        Assert.assertTrue(signUpPage.chooseBusinessAccount(), "Business account radio button isn't checked");
    }

    @Test
    public void verifyUnregisteredUserCanAddProductToShoppingCart() {
        HomePage homePage = new HomePage(driver);
        SignUpPage signUpPage = homePage.clickRegisterButton();
        Assert.assertTrue(signUpPage.chooseBusinessAccount(), "Business account radio button isn't checked");
    }
}
