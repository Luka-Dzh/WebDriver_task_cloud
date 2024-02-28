package org.epam.pages;

import org.epam.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final String SEARCH_ICON_XPATH = "//div[@class='YSM5S']";
    private static final String INPUT_XPATH = "//input[@class='qdOxv-fmcmS-wGMbrd']";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        driver.get("https://cloud.google.com/");
        return this;
    }

    public StartingPage search() {
        waitForElements(driver.findElement(By.xpath(SEARCH_ICON_XPATH))).click();
        driver.findElement(By.xpath(INPUT_XPATH)).sendKeys("Google Cloud Platform Pricing Calculator");
        driver.findElement(By.xpath(INPUT_XPATH)).sendKeys(Keys.ENTER);

        return new StartingPage(driver);
    }
}
