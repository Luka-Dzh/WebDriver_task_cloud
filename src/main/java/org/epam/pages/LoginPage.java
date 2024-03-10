package org.epam.pages;

import org.epam.BasePage;
import org.epam.decorator.PageDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private static final String SEARCH_ICON_XPATH = "//div[@class='YSM5S']";
    private static final String INPUT_XPATH = "//input[@class='qdOxv-fmcmS-wGMbrd']";
    private final PageDecorator pageDecorator;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.pageDecorator = new PageDecorator(driver, this);
    }

    public LoginPage open() {
        driver.get("https://cloud.google.com/");
        return this;
    }

    public StartingPage search() {
        pageDecorator.waitForElements(driver.findElement(By.xpath(SEARCH_ICON_XPATH))).click();
        WebElement input = driver.findElement(By.xpath(INPUT_XPATH));
        input.sendKeys("Google Cloud Platform Pricing Calculator");
        input.sendKeys(Keys.ENTER);

        return new StartingPage(driver);
    }
}
