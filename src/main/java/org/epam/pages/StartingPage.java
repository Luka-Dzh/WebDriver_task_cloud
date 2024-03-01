package org.epam.pages;

import org.checkerframework.checker.units.qual.C;
import org.epam.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class StartingPage extends BasePage {
    @FindBy(xpath = "//a[@class='K5hUy' and @href=\"https://cloud.google.com/products/calculator-legacy?hl=es-419\"]")
    private WebElement calculator;
    private static final String CALCULATOR_XPATH =
            "//a[@class='K5hUy' and @href=\"https://cloud.google.com/products/calculator-legacy?hl=es-419\"]";

    public StartingPage(WebDriver driver) {
        super(driver);
    }
    public CalculatorPage search(){

        //waitForElements(driver.findElement(By.xpath(CALCULATOR_XPATH))).click(); //it does not work this way
        waitForElements(calculator).click();
        return new CalculatorPage(driver);
    }
}
