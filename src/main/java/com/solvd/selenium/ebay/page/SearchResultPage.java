package com.solvd.selenium.ebay.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;
import java.util.stream.Collectors;

public class SearchResultPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='s0-51-16-0-1-2-6']/li[2]/span/button")
    private WebElement moreFiltersButton;

    @FindBy(xpath = "//*[@id='refineOverlay']/div[2]")
    private WebElement filterElement;

    @FindBy(xpath = "//*[@class='s-item__wrapper clearfix']")
    private List<WebElement> resultsList;

    @FindBy(xpath = "//*[@class='s-item__title']/span[contains(text(),'iPhone')]")
    private List<WebElement> productsTitle;

    @FindBy(xpath = "//*[@id='gh-ac']")
    private WebElement inputField;

    @FindBy(xpath = "//*[@id='x-refine__group_1__0']/ul/li[1]/div/a/div/span/input")
    private WebElement checkBox;

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

    public List<String> showResults() {
        return productsTitle.stream()
                .map(title -> title.getText().toLowerCase(Locale.ROOT))
                .collect(Collectors.toList());
    }

    public ProductPage chooseRandomProduct() {
        Random random = new Random();
        clickWebElement(productsTitle.get(random.nextInt(resultsList.size())));
        switchToWindows();
        return new ProductPage(driver);
    }
}
