package com.solvd.selenium.ebay;

import com.solvd.selenium.ebay.utils.CapabilityFactory;

import com.solvd.selenium.ebay.utils.PropertyReader;
import com.solvd.selenium.ebay.utils.Screenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;

public class AbstractTest {
    protected static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public CapabilityFactory capabilityFactory = new CapabilityFactory();


    @BeforeMethod
    @Parameters({"browserName"})
    public void setUp(String browserName) {
       WebDriver driver = new RemoteWebDriver(capabilityFactory.getCapabilities(browserName));
       driver.get(PropertyReader.getProperty("url"));
       webDriver.set(driver);
    }

    public WebDriver getDriver() {
        return webDriver.get();
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE){
            Screenshot.takeScreenshot(getDriver(), result.getName());
        }
        getDriver().quit();
        webDriver.remove();
    }
}
