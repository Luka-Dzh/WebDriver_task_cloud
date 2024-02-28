package org.epam.pages;

import org.epam.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class StartingPage extends BasePage {
    @FindBy(xpath = "// a[@class='K5hUy' and @href=\"https://cloud.google.com/products/calculator-legacy?hl=es-419\"]")
    private WebElement pricingCalculator;
    public StartingPage(WebDriver driver) {
        super(driver);
    }
    public CalculatorPage search(){
        this.waitForElements(pricingCalculator).click();

        return new CalculatorPage(driver);
    }
}
