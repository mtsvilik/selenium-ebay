package com.solvd.selenium.ebay.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage extends AbstractPage {

    @FindBy(xpath = "/html/body/div[4]/div[2]/h1/span")
    private WebElement pageTitle;

    public CategoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return getText(pageTitle);
    }
}
