package com.solvd.selenium.ebay;

import com.solvd.selenium.ebay.utils.PropertyReader;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Set;

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
        driver.navigate().refresh();
    }

    private void addCookie() {
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println(cookies.size());
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + " : " + cookie.getValue());
        }

        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
