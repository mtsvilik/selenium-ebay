package com.solvd.selenium.ebay;

import com.solvd.selenium.ebay.utils.PropertyReader;

import com.solvd.selenium.ebay.utils.TestDataReader;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class AbstractTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", PropertyReader.getProperty("path"));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(PropertyReader.getProperty("url"));
        addCookie();
    }

    private void addCookie() {
        driver.manage().addCookie(new Cookie(TestDataReader.getTestData("cookieName"),
                TestDataReader.getTestData("cookieValue")));
        driver.manage().addCookie(new Cookie(TestDataReader.getTestData("cookieName"),
                TestDataReader.getTestData("cookieValueForCart")));
        driver.manage().addCookie(new Cookie(TestDataReader.getTestData("cookieNameForBusiness"),
                TestDataReader.getTestData("cookieValueForBusiness")));
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
