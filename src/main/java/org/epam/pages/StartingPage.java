package org.epam.pages;

import org.epam.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class StartingPage extends BasePage {
    @FindBy(xpath = "// a[@class='gs-title']")
    private WebElement pricingCalculator;
    public StartingPage(WebDriver driver) {
        super(driver);
    }
    public CalculatorPage search(){
        this.pricingCalculator.click();

        return new CalculatorPage(driver);
    }
}
