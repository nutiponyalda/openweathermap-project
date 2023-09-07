package org.openweathermap.steps;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseSeleniumTest {
    protected WebDriver driver;
    @BeforeEach
    public void configBrowser() {
        Configuration.browser = "chrome";
        Configuration.reopenBrowserOnFail = true;
        Configuration.browserCapabilities = new DesiredCapabilities();
        Configuration.browserCapabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
    }

    @AfterEach
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
