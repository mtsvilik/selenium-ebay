package com.solvd.selenium.ebay.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='DESCRIPTION_VHR_SHIPPING_TABS0-0-1-tabs-1']")
    private WebElement shippingButton;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void showShippingInfo() {
        clickElement(shippingButton, 5);
    }

    public boolean getShippingButton() {
        return shippingButton.isSelected();
    }
}
