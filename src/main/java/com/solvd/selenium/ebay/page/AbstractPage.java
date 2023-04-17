package com.solvd.selenium.ebay.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractPage.class);
    private static final Duration TIMEOUT = Duration.ofSeconds(15);

    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickElement(WebElement element) {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.visibilityOf(element)).click();
        LOGGER.info("Element " + element.getTagName() + " was clicked");
    }

    public void clickElement(WebElement element, int multiplier) {
        new WebDriverWait(driver, TIMEOUT.multipliedBy(multiplier))
                .until(ExpectedConditions.visibilityOf(element)).click();
        LOGGER.info("Element " + element.getTagName() + " was clicked");
    }

    public void sendKeys(WebElement element, String input) {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(element)).sendKeys(input);
        LOGGER.info(String.format("'%s' was typed ", input));
    }

    public void clickWebElement(WebElement element) {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(element));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public void navigateToWebElement(WebElement element) {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.visibilityOf(element));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void clickCheckBox(WebElement element) {
        WebElement checkBoxElement = new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(element));
        boolean isSelected = checkBoxElement.isSelected();
        if (!isSelected) {
            checkBoxElement.click();
        }
    }
}
