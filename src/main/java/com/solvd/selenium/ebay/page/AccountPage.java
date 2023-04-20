package com.solvd.selenium.ebay.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='gh-ug']")
    private WebElement userNameButton;

    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getUserName() {
        return getText(userNameButton);
    }
}
