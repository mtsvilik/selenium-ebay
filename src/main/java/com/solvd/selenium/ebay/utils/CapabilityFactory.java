package com.solvd.selenium.ebay.utils;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariOptions;

public class CapabilityFactory {

    public Capabilities capabilities;

    public Capabilities getCapabilities(String browser) {
        switch (browser) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                capabilities = options;
                break;
            case "firefox":
                capabilities = new FirefoxOptions();
                break;
            case "safari":
                capabilities = new SafariOptions();
                break;
            default:
                break;
        }
        return capabilities;
    }
}