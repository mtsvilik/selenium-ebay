package com.solvd.selenium.ebay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class AbstractTest {

    protected static final ThreadLocal<RemoteWebDriver> remoteDriver = new ThreadLocal<>();

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);
        remoteDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities));
    }

    public WebDriver getDriver() {
        return remoteDriver.get();
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }
}
