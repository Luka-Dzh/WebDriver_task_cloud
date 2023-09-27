package org.epam.pages;

import org.epam.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CalculatorPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"input_98\"]")
    private WebElement numberOfInstances;
    @FindBy(xpath = "//md-select-value [@id=\"select_value_label_93\"]")
    private WebElement selectorForSeries;
    @FindBy(xpath = "//md-select-value[@id=\"select_value_label_94\"]")
    private WebElement machineType;
    @FindBy(xpath ="//md-checkbox[@aria-label=\"Add GPUs\"][1]")
    private WebElement addGpu;
    @FindBy(xpath = "//md-select-value [@id=\"select_value_label_463\"]")
    private WebElement localSsd;
    @FindBy(xpath = "//md-select[@placeholder=\"GPU type\"]")
    private WebElement gpuType;
    @FindBy(xpath = "//md-select[@id=\"select_507\"]")
    private WebElement numberOfGpu;
    @FindBy(xpath = "//md-select-value[@id=\"select_value_label_96\"]")
    private WebElement datacenterLocation;
    @FindBy(xpath = "//md-select-value[@id=\"select_value_label_97\"]")
    private WebElement comittedUsage;
    @FindBy(xpath = "//button[contains(text(),\"Add to Estimate\")]")
    private WebElement addToEstimate;
    @FindBy(xpath = "//button[@id=\"Email Estimate\"]")
    private WebElement emailEstimate;
    @FindBy(xpath = "//b[@class=\"ng-binding\"]")
    private WebElement estimatedPrice;

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }
    public EmailPage setValues(){
        driver.switchTo().frame(0);
        WebElement iFrame = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myFrame\"]")));
        driver.switchTo().frame("myFrame");



        numberOfInstances.sendKeys("4");

        selectorForSeries.click();
        WebElement elementSeries = driver.findElement(By.xpath("//md-option[@value=\"n1\"]"));
        waitForElements(elementSeries).click();
        //selectorForSeries.findElement(By.xpath("//md-option[@value=\"n1\"]")).click();

        machineType.click();
        WebElement elementMachine = driver.findElement(By.xpath("//md-option[@id=\"select_option_469\"]"));
        waitForElements(elementMachine).click();
        //machineType.findElement(By.xpath("//md-option[@id=\"select_option_469\"]")).click();

        addGpu.click();

        localSsd.click();
        WebElement elementSsd = driver.findElement(By.xpath("//md-option[@id=\"select_option_490\"]"));
        waitForElements(elementSsd).click();
        //localSsd.findElement(By.xpath("//md-option[@id=\"select_option_490\"]")).click();

        gpuType.click();
        WebElement elementGpu = driver.findElement(By.xpath("//md-option[@id=\"select_option_512\"]"));
        waitForElements(elementGpu).click();
        //gpuType.findElement(By.xpath("//md-option[@id=\"select_option_512\"]")).click();

        numberOfGpu.click();
        WebElement elementNumberGpu = driver.findElement(By.xpath("//md-option[@id=\"select_option_515\"]"));
        waitForElements(elementNumberGpu).click();
        //numberOfGpu.findElement(By.xpath("//md-option[@id=\"select_option_515\"]")).click();

        datacenterLocation.click();
        WebElement elementDatacenter = driver.findElement(By.xpath("//md-option[@id=\"select_option_263\"]"));
        waitForElements(elementDatacenter).click();
        //datacenterLocation.findElement(By.xpath("//md-option[@id=\"select_option_263\"]")).click();

        comittedUsage.click();
        WebElement elementUsage = driver.findElement(By.xpath("//md-option[@id=\"select_option_136\"]"));
        waitForElements(elementUsage).click();
        //comittedUsage.findElement(By.xpath("//md-option[@id=\"select_option_136\"]")).click();

        addToEstimate.click();
        emailEstimate.click();

        return new EmailPage(driver);
    }
    public String estimated(){
        String originalWindowHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        driver.switchTo().frame(0);
        WebElement iFrame = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myFrame\"]")));
        driver.switchTo().frame("myFrame");
        return estimatedPrice.getText();
    }
}
