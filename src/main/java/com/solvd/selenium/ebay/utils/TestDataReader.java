package com.solvd.selenium.ebay.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDataReader {

    private static final Properties PROPERTIES = new Properties();

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/testdata.properties");
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getTestData(String key) {
        return PROPERTIES.getProperty(key);
    }
}
