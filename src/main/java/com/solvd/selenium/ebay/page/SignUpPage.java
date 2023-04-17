package com.solvd.selenium.ebay.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='EMAIL_REG_FORM_SUBMIT']")
    private WebElement createAccountButton;

    @FindBy(xpath = "//*[@id='businessaccount-radio']")
    private WebElement businessAccountRadio;

    public SignUpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean clickCreateAccount() {
        driver.switchTo().activeElement();
        return createAccountButton.isSelected();
    }

    public boolean chooseBusinessAccount() {
        driver.switchTo().activeElement();
        Actions action = new Actions(driver);
        action.moveToElement(businessAccountRadio).perform();
        businessAccountRadio.click();
        return businessAccountRadio.isSelected();
    }
}
