package com.solvd.selenium.ebay.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends AbstractPage {

    @FindBy(xpath = ("//*[@id='userid']"))
    private WebElement emailField;

    @FindBy(xpath = ("//*[@id='pass']"))
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='signin-continue-btn']")
    private WebElement continueButton;

    @FindBy(xpath = "//*[@id='sgnBt']")
    private WebElement signInButton;

    public SignInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
        switchToActiveElement();
        sendKeys(emailField, email);
        clickWebElement(continueButton);
    }

    public AccountPage enterPassword(String password) {
        switchToActiveElement();
        sendKeys(passwordField, password);
        clickWebElement(signInButton);
        return new AccountPage(driver);
    }
}
