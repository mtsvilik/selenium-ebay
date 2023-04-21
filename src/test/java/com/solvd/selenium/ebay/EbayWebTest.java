package com.solvd.selenium.ebay;

import com.solvd.selenium.ebay.page.*;
import com.solvd.selenium.ebay.utils.TestDataReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class EbayWebTest extends AbstractTest {

    @Test
    public void verifyShoppingCartIconIsClickableTest() {
        HomePage homePage = new HomePage(getDriver());
        ShoppingCartPage shoppingCartPage = homePage.clickShoppingCartIcon();
        Assert.assertEquals(shoppingCartPage.getEmptyCartText(), TestDataReader.getTestData("text"),
                "Shopping cart page should contains cart is empty text");
    }

    @Test
    public void checkSignInWithValidDataTest() {
        HomePage homePage = new HomePage(getDriver());
        SignInPage signInPage = homePage.clickSignInButton();
        signInPage.enterEmail(TestDataReader.getTestData("email"));
        AccountPage accountPage = signInPage.enterPassword(TestDataReader.getTestData("password"));
        Assert.assertEquals(accountPage.getUserName(), TestDataReader.getTestData("userName"),
                "Account page should contains sign in text");
    }

    @Test
    public void verifyElectronicsMainContentIsWorkingTest() {
        HomePage homePage = new HomePage(getDriver());
        CategoryPage categoryPage = homePage.chooseComputerCategory();
        Assert.assertEquals(categoryPage.getPageTitle(), TestDataReader.getTestData("pageTitle"),
                "Category page should contains page title text");
    }

    @Test
    public void verifyMoreFiltersButtonIsClickableTest() {
        HomePage homePage = new HomePage(getDriver());
        SearchResultPage searchResultPage = homePage.openResultPage(TestDataReader.getTestData("searchText"));
        searchResultPage.clickMoreFiltersButton();
        Assert.assertTrue(searchResultPage.getFilterElement(), "Filter element isn't present");
    }

    @Test
    public void verifyRegistrationWithEmptyRequiredFieldsTest() {
        HomePage homePage = new HomePage(getDriver());
        SignUpPage signUpPage = homePage.clickRegisterButton();
        Assert.assertFalse(signUpPage.clickCreateAccount(), "Create account button isn't clickable");
    }

    @Test
    public void verifyBusinessAccountRadioButtonIsCheckedTest() {
        HomePage homePage = new HomePage(getDriver());
        SignUpPage signUpPage = homePage.clickRegisterButton();
        Assert.assertTrue(signUpPage.chooseBusinessAccount(),
                "Business account radio button isn't checked");
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

    @Test
    public void verifyAllCategoriesSelectIsWorkingTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.checkSelect();
        Assert.assertEquals(homePage.getSelectTitle(), TestDataReader.getTestData("selectTitle"),
                "All Categories select isn't worked");
    }
}
