package org.epam.pages;

import org.epam.BasePage;
import org.epam.decorator.PageDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class StartingPage extends BasePage {
    @FindBy(xpath = "//a[@class='K5hUy' and @href=\"https://cloud.google.com/products/calculator-legacy?hl=es-419\"]")
    private WebElement calculator;
    private final PageDecorator pageDecorator;

    public StartingPage(WebDriver driver) {
        super(driver);
        this.pageDecorator = new PageDecorator(driver, this);
    }

    public CalculatorPage search() {
        pageDecorator.waitForElements(calculator).click();
        return new CalculatorPage(driver);
    }
}
