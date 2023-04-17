package com.solvd.selenium.ebay;

import com.solvd.selenium.ebay.utils.PropertyReader;
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
        System.setProperty("browser", "path");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(PropertyReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
