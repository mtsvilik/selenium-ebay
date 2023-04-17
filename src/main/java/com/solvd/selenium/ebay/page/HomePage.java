package com.solvd.selenium.ebay.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//*[@id='gh-minicart-hover']")
    private WebElement shoppingCartIcon;

    @FindBy(xpath = "//*[@id='gh-ug']")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@id='gh-ug-flex']/a")
    private WebElement registerButton;

    @FindBy(xpath = "//*[@id='gdpr-banner']")
    private WebElement cookiesBanner;

    @FindBy(xpath = "//*[@id='gdpr-banner-accept']")
    private WebElement acceptAllCookiesButton;

    @FindBy(xpath = "//*[@id='mainContent']/div[1]/ul/li[4]/a")
    private WebElement electronicsButton;

    @FindBy(xpath = "//*[@id='mainContent']/div[1]/ul/li[4]/div[2]/div[1]/nav[1]/ul/li[1]/a")
    private WebElement computerCategoryButton;

    @FindBy(xpath = "//*[@id='gh-ac']")
    private WebElement inputField;

    @FindBy(xpath = "//*[@id='gh-btn']")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SignInPage clickSignInButton() {
        clickWebElement(signInButton);
        return new SignInPage(driver);
    }

    public SignUpPage clickRegisterButton() {
        clickWebElement(registerButton);
        return new SignUpPage(driver);
    }

    public ShoppingCartPage clickShoppingCartIcon() {
        clickWebElement(shoppingCartIcon);
        return new ShoppingCartPage(driver);
    }

    public CategoryPage chooseComputerCategory() {
        navigateToWebElement(electronicsButton);
        clickWebElement(computerCategoryButton);
        return new CategoryPage(driver);
    }

    public SearchResultPage openResultPage(String searchText) {
        sendKeys(inputField, searchText);
        clickElement(searchButton);
        return new SearchResultPage(driver);
    }
}
