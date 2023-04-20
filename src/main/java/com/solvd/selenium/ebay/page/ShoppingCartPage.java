package com.solvd.selenium.ebay.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='mainContent']/div/div[2]/div/div/div/div[1]/span/span/span")
    private WebElement emptyCartText;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getEmptyCartText() {
        return getText(emptyCartText);
    }
}
