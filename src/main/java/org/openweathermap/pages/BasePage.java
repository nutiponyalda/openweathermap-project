package org.openweathermap.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    public static WebDriver driver;
    public static void setDriver(WebDriver webDriver){
        driver = webDriver;
    }
}
