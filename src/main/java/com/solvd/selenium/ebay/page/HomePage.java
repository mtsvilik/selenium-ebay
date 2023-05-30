package com.solvd.selenium.ebay.page;

import com.solvd.selenium.ebay.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);

    @FindBy(xpath = "//*[@id='gh-minicart-hover']")
    private WebElement shoppingCartIcon;

    @FindBy(xpath = "//*[@id='gdpr-banner-accept']")
    private WebElement acceptAllButton;

    @FindBy(xpath = "//*[@id='gh-ug']")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@id='gh-ug-flex']/a")
    private WebElement registerButton;

    @FindBy(xpath = "//*[@id='mainContent']/div[1]/ul/li[4]/a")
    private WebElement electronicsButton;

    @FindBy(xpath = "//*[@id='mainContent']/div[1]/ul/li[4]/div[2]/div[1]/nav[1]/ul/li[1]/a")
    private WebElement computerCategoryButton;

    @FindBy(xpath = "//*[@id='gh-ac']")
    private WebElement inputField;

    @FindBy(xpath = "//*[@id='gh-btn']")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id='gh-cat']")
    private WebElement allCategoriesButton;

    @FindBy(xpath = "//*[@id='gh-cat']/option[34]")
    private WebElement select;

    @FindBy(xpath = "//*[@id='areaTitle']/h1")
    private WebElement captcha;

    public HomePage(WebDriver driver) {
        super(driver);
        driver.get(PropertyReader.getProperty("url"));
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

    public void checkSelect() {
        Select select = new Select(allCategoriesButton);
        select.selectByValue("267");
        select.selectByVisibleText("Music");
        select.selectByVisibleText("Travel");
        WebElement firstOption = select.getFirstSelectedOption();
        LOGGER.info(String.format("Element %s was selected ", firstOption.getText()));
    }

    public String getSelectTitle() {
        return getText(select);
    }
}
