package org.epam.pages;

import org.epam.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {
    @FindBy(xpath = "//div[@class='YSM5S']")
    private WebElement searchIcon;
    @FindBy(xpath = "//input[@class='qdOxv-fmcmS-wGMbrd']")
    private WebElement input;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        driver.get("https://cloud.google.com/");
        return this;
    }

    public StartingPage search() {
        this.waitForElements(searchIcon).click();
        this.input.sendKeys("Google Cloud Platform Pricing Calculator");
        this.input.sendKeys(Keys.ENTER);

        return new StartingPage(driver);
    }
}
