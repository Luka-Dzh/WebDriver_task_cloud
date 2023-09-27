package org.epam.pages;

import org.epam.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@class='mb2a7b' and @name='q']")
    private WebElement searchIcon;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        driver.get("https://cloud.google.com/");
        return this;
    }

    public StartingPage search() {
        this.searchIcon.click();
        this.searchIcon.sendKeys("Google Cloud Platform Pricing Calculator");
        this.searchIcon.sendKeys(Keys.ENTER);

        return new StartingPage(driver);
    }
}
