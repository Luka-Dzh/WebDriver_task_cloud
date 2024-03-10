package org.epam.pages;

import org.epam.BasePage;
import org.epam.Utility;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class EmailPage extends BasePage {
    private final Utility utility = new Utility(driver);
    private static final String RANDOM_EMAIL_XPATH = "//a[@href=\"email-generator\"]";
    private static final String EMAIL_XPATH = "//div[@id=\"geny\"]";
    private static final String EMAIL_FIELD_XPATH = "//input[@type=\"email\"]";
    private static final String SEND_EMAIL_XPATH = "//button[@class=\"md-raised md-primary cpc-button md-button md-ink-ripple\"and contains(text(),\"Send Email\")]";
    private static final String CHECK_EMAIL_XPATH = "//button[@class=\"md but text f24 egenbut\"and @onclick=\"egengo();\"]";
    private static final String ESTIMATION_XPATH = "//*[contains(text(),\"Estimated Monthly Cost:\")]";


    public EmailPage(WebDriver driver) {
        super(driver);
    }

    public EmailPage open() {//opens the random email generation site
        driver.switchTo().newWindow(WindowType.TAB);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");
        driver.get("https://yopmail.com/en/");
        return this;
    }

    public CalculatorPage creatingEmail() {

        driver.findElement(By.xpath(RANDOM_EMAIL_XPATH)).click();
        driver.navigate()
                .back();// to avoid AD
        driver.findElement(By.xpath(RANDOM_EMAIL_XPATH)).click();

        String copyEmail = driver.findElement(By.xpath(EMAIL_XPATH)).getText();

        utility.changeTab();

        driver.switchTo()
                .frame(0);
        WebElement iFrame = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//*[@id=\"myFrame\"]")));
        driver.switchTo()
                .frame("myFrame");

        driver.findElement(By.xpath(EMAIL_FIELD_XPATH)).click();
        driver.findElement(By.xpath(EMAIL_FIELD_XPATH)).sendKeys(copyEmail);
        driver.findElement(By.xpath(SEND_EMAIL_XPATH)).click();

        utility.changeTab();

        driver.switchTo()
                .defaultContent();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 200);");
        new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.xpath(CHECK_EMAIL_XPATH)).click();

        return new CalculatorPage(driver);
    }

    public String estimatedEmail() {
        driver.navigate()
                .refresh();
        driver.navigate()
                .refresh();//to see the email

        WebElement iFrame = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ifmail\"]")));
        driver.switchTo().frame("ifmail");
        return driver.findElement(By.xpath(ESTIMATION_XPATH)).getText();
    }
}
