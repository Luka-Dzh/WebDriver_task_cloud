package org.epam.pages;

import org.epam.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class StartingPage extends BasePage {
    private static final String CALCULATOR_XPATH = "// a[@class='K5hUy' and @href=\"https://cloud.google.com/products/calculator-legacy?hl=es-419\"]";

    public StartingPage(WebDriver driver) {
        super(driver);
    }
    public CalculatorPage search(){
        waitForElements(driver.findElement(By.xpath(CALCULATOR_XPATH))).click();

        return new CalculatorPage(driver);
    }
}
