package org.epam.decorator;

import org.epam.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageDecorator extends BasePage {
    private BasePage page;

    public PageDecorator(WebDriver driver, BasePage page) {
        super(driver);
        this.page = page;
    }

    @Override
    public WebElement waitForElements(WebElement element) {
        System.out.println("Waiting for element on page: " + page.getClass().getSimpleName());
        return page.waitForElements(element);
    }
}
