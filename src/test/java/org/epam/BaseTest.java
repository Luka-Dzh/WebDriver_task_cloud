package org.epam;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.epam.singletone.WebDriverSingleton;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected final WebDriver driver = WebDriverSingleton.getDriver();

    protected void setUpWebDriver() {
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
    }

    protected void quit() {
        driver.quit();
    }
}
