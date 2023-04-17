package com.solvd.selenium.ebay.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='s0-51-16-0-1-2-6']/li[2]/span/button")
    private WebElement moreFiltersButton;

    @FindBy(xpath = "//*[@id='refineOverlay']/div[2]")
    private WebElement filterElement;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickMoreFiltersButton() {
        clickWebElement(moreFiltersButton);
        navigateToWebElement(filterElement);
    }

    public boolean getFilterElement() {
        return filterElement.isDisplayed();
    }
}
