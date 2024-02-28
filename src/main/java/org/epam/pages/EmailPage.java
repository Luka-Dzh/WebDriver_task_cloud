package org.epam.pages;

import org.epam.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class EmailPage extends BasePage {
    @FindBy(xpath = "//a[@href=\"email-generator\"]")
    private WebElement randomEmail;

    @FindBy(xpath = "//div[@id=\"geny\"]")
    private WebElement email;
    @FindBy(xpath = "//input[@type=\"email\"]")
    private WebElement emailField;
    @FindBy(xpath = "//button[@class=\"md-raised md-primary cpc-button md-button md-ink-ripple\"and contains(text(),\"Send Email\")]")
    private WebElement sendEmail;
    @FindBy(xpath = "//button[@class=\"md but text f24 egenbut\"and @onclick=\"egengo();\"]")
    private WebElement checkEmail;

    public EmailPage(WebDriver driver) {
        super(driver);
    }

    public EmailPage open() {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");
        driver.get("https://yopmail.com/en/");
        return this;
    }

    public EmailPage changeTab() {
        String originalWindowHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        return this;
    }

    public CalculatorPage creatingEmail() {

        randomEmail.click();
        driver.navigate().back();
        randomEmail.click();

        String copyEmail = email.getText();

        changeTab();

        driver.switchTo().frame(0);
        WebElement iFrame = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myFrame\"]")));
        driver.switchTo().frame("myFrame");
        emailField.click();
        emailField.sendKeys(copyEmail);
        sendEmail.click();

        changeTab();

        driver.switchTo().defaultContent();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 200);");
        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        checkEmail.click();

        return new CalculatorPage(driver);
    }
    public String estimatedEmail(){
        driver.navigate().refresh();
        driver.navigate().refresh();
        WebElement iFrame = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ifmail\"]")));
        driver.switchTo().frame("ifmail");
        String estimation = driver.findElement(By.xpath("//td[@style=\"margin-left: 11px !important; border: 1px solid rgba(187, 187, 187, 1) !important; padding: 14px !important; font-size: 13px !important; vertical-align: top\" and contains(text(),\"USD\")]")).getText();
        String estimation2 = driver.findElement(By.xpath("//*[contains(text(),\"Estimated Monthly Cost:\")]")).getText();
        return estimation;
    }
}
